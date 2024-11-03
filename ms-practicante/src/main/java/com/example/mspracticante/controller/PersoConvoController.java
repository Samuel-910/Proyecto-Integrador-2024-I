package com.example.mspracticante.controller;

import com.example.mspracticante.entity.PersoConvo;
import com.example.mspracticante.service.PersoConvoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persoconvo")
public class PersoConvoController {

    @Autowired
    private PersoConvoService persoConvoService;

    // Listar todos los registros
    @GetMapping
    public ResponseEntity<List<PersoConvo>> listar() {
        List<PersoConvo> persoConvos = persoConvoService.listar();
        return ResponseEntity.ok(persoConvos);
    }

    // Buscar un registro por ID
    @GetMapping("/{id}")
    public ResponseEntity<PersoConvo> buscarPorId(@PathVariable Integer id) {
        try {
            PersoConvo persoConvo = persoConvoService.buscarPorId(id);
            return ResponseEntity.ok(persoConvo);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Guardar un nuevo registro
    @PostMapping
    public ResponseEntity<PersoConvo> guardar(@RequestBody PersoConvo persoConvo) {
        PersoConvo nuevoPersoConvo = persoConvoService.guardar(persoConvo);
        return ResponseEntity.ok(nuevoPersoConvo);
    }

    // Actualizar un registro existente
    @PutMapping("/{id}")
    public ResponseEntity<PersoConvo> actualizar(@PathVariable Integer id, @RequestBody PersoConvo persoConvo) {
        try {
            persoConvo.setId(id);
            PersoConvo persoConvoActualizado = persoConvoService.actualizar(persoConvo);
            return ResponseEntity.ok(persoConvoActualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar un registro por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        try {
            persoConvoService.eliminar(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
