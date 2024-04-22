package com.example.msempresa.controller;

import com.example.msempresa.entity.Convocatoria;
import com.example.msempresa.service.ConvocatoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/convocatoria")
public class ConvocatoriaController {
    @Autowired
    private ConvocatoriaService convocatoriaService;

    @GetMapping
    public ResponseEntity<List<Convocatoria>> listar() {
        return ResponseEntity.ok(convocatoriaService.listar());
    }

    @PostMapping
    public ResponseEntity<Convocatoria> guardar(@RequestBody Convocatoria convocatoria) {
        return ResponseEntity.ok(convocatoriaService.guardar(convocatoria));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Convocatoria> buscarPOrId(@PathVariable(required = true) Integer id) {
        return ResponseEntity.ok(convocatoriaService.buscarPorId(id).get());
    }

    @PutMapping
    public ResponseEntity<Convocatoria> actualizar(@RequestBody Convocatoria convocatoria) {
        return ResponseEntity.ok(convocatoriaService.actualizar(convocatoria));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List<Convocatoria>> eliminar(@PathVariable(required = true) Integer id) {
        convocatoriaService.eliminar(id);
        return ResponseEntity.ok(convocatoriaService.listar());
    }
}
