package com.example.mspracticante.controller;

import com.example.mspracticante.entity.Constancia;
import com.example.mspracticante.service.ConstanciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/constancia")
public class ConstanciaController {
    @Autowired
    private ConstanciaService constanciaService;

    @GetMapping
    public ResponseEntity<List<Constancia>> listar() {
        return ResponseEntity.ok(constanciaService.listar());
    }

    @PostMapping
    public ResponseEntity<Constancia> guardar(@RequestBody Constancia constancia) {
        return ResponseEntity.ok(constanciaService.guardar(constancia));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Constancia> buscarPOrId(@PathVariable(required = true) Integer id) {
        return ResponseEntity.ok(constanciaService.buscarPorId(id).get());
    }

    @PutMapping
    public ResponseEntity<Constancia> actualizar(@RequestBody Constancia constancia) {
        return ResponseEntity.ok(constanciaService.actualizar(constancia));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List<Constancia>> eliminar(@PathVariable(required = true) Integer id) {
        constanciaService.eliminar(id);
        return ResponseEntity.ok(constanciaService.listar());
    }
}
