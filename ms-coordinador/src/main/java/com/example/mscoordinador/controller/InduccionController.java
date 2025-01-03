package com.example.mscoordinador.controller;

import com.example.mscoordinador.entity.Empresa;
import com.example.mscoordinador.entity.Induccion;
import com.example.mscoordinador.service.InduccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/induccion")
public class InduccionController {
    @Autowired
    private InduccionService induccionService;

    @GetMapping
    public ResponseEntity<List<Induccion>> listar() {
        return ResponseEntity.ok(induccionService.listar());
    }

    @PostMapping
    public ResponseEntity<Induccion> guardar(@RequestBody Induccion induccion) {
        return ResponseEntity.ok(induccionService.guardar(induccion));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Induccion> buscarPorId(@PathVariable(required = true) Integer id) {
        return ResponseEntity.ok(induccionService.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Induccion> actualizar(@PathVariable(required = true) Integer id, @RequestBody Induccion induccion) {
        return ResponseEntity.ok(induccionService.actualizar(id,induccion));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List<Induccion>> eliminar(@PathVariable(required = true) Integer id) {
        induccionService.eliminar(id);
        return ResponseEntity.ok(induccionService.listar());
    }
}
