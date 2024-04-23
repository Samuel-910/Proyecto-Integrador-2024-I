package com.example.mspracticante.controller;

import com.example.mspracticante.entity.Carta_aceptacion;
import com.example.mspracticante.service.Carta_aceptacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Carta_aceptacion")
public class Carta_aceptacionController {
    @Autowired
    private Carta_aceptacionService carta_aceptacionService;

    @GetMapping
    public ResponseEntity<List<Carta_aceptacion>> listar() {
        return ResponseEntity.ok(carta_aceptacionService.listar());
    }

    @PostMapping
    public ResponseEntity<Carta_aceptacion> guardar(@RequestBody Carta_aceptacion carta_aceptacion) {
        return ResponseEntity.ok(carta_aceptacionService.guardar(carta_aceptacion));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carta_aceptacion> buscarPOrId(@PathVariable(required = true) Integer id) {
        return ResponseEntity.ok(carta_aceptacionService.buscarPorId(id).get());
    }

    @PutMapping
    public ResponseEntity<Carta_aceptacion> actualizar(@RequestBody Carta_aceptacion carta_aceptacion) {
        return ResponseEntity.ok(carta_aceptacionService.actualizar(carta_aceptacion));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List<Carta_aceptacion>> eliminar(@PathVariable(required = true) Integer id) {
        carta_aceptacionService.eliminar(id);
        return ResponseEntity.ok(carta_aceptacionService.listar());
    }
}
