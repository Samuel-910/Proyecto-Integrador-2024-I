package com.example.mscoordinador.controller;

import com.example.mscoordinador.entity.Carta_presentacion;
import com.example.mscoordinador.service.Carta_presentacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carta_presentacion")
@CrossOrigin
public class Carta_presentacionController {
    @Autowired
    private Carta_presentacionService carta_presentacionService;

    @GetMapping
    public ResponseEntity<List<Carta_presentacion>> listar() {
        return ResponseEntity.ok(carta_presentacionService.listar());
    }

    @PostMapping
    public ResponseEntity<Carta_presentacion> guardar(@RequestBody Carta_presentacion carta_presentacion) {
        return ResponseEntity.ok(carta_presentacionService.guardar(carta_presentacion));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carta_presentacion> buscarPorId(@PathVariable(required = true) Integer id) {
        return ResponseEntity.ok(carta_presentacionService.buscarPorId(id));
    }

    @PutMapping
    public ResponseEntity<Carta_presentacion> actualizar(@RequestBody Carta_presentacion carta_presentacion) {
        return ResponseEntity.ok(carta_presentacionService.actualizar(carta_presentacion));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List<Carta_presentacion>> eliminar(@PathVariable(required = true) Integer id) {
        carta_presentacionService.eliminar(id);
        return ResponseEntity.ok(carta_presentacionService.listar());
    }
}
