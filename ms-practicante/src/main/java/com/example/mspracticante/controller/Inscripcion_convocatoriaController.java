package com.example.mspracticante.controller;

import com.example.mspracticante.entity.Inscripcion_convocatoria;
import com.example.mspracticante.service.Inscripcion_convocatoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inscripcion_convocatoria")
public class Inscripcion_convocatoriaController {
    @Autowired
    private Inscripcion_convocatoriaService inscripcion_convocatoriaService;

    @GetMapping
    public ResponseEntity<List<Inscripcion_convocatoria>> listar() {
        return ResponseEntity.ok(inscripcion_convocatoriaService.listar());
    }

    @PostMapping
    public ResponseEntity<Inscripcion_convocatoria> guardar(@RequestBody Inscripcion_convocatoria inscripcion_convocatoria) {
        return ResponseEntity.ok(inscripcion_convocatoriaService.guardar(inscripcion_convocatoria));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inscripcion_convocatoria> buscarPOrId(@PathVariable(required = true) Integer id) {
        return ResponseEntity.ok(inscripcion_convocatoriaService.buscarPorId(id));
    }

    @PutMapping
    public ResponseEntity<Inscripcion_convocatoria> actualizar(@RequestBody Inscripcion_convocatoria inscripcion_convocatoria) {
        return ResponseEntity.ok(inscripcion_convocatoriaService.actualizar(inscripcion_convocatoria));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List<Inscripcion_convocatoria>> eliminar(@PathVariable(required = true) Integer id) {
        inscripcion_convocatoriaService.eliminar(id);
        return ResponseEntity.ok(inscripcion_convocatoriaService.listar());
    }
}
