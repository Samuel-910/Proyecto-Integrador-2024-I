package com.example.mspracticante.controller;

import com.example.mspracticante.entity.Practicante;
import com.example.mspracticante.repository.PracticanteRepository;
import com.example.mspracticante.service.PracticanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/practicante")
public class PracticanteController {
    @Autowired
    private PracticanteService practicanteService;

    @Autowired
    private PracticanteRepository practicanteRepository;

    @GetMapping
    public ResponseEntity<List<Practicante>> listar() {
        return ResponseEntity.ok(practicanteService.listar());
    }

    @PostMapping
    public ResponseEntity<Practicante> guardar(@RequestBody Practicante practicante) {
        return ResponseEntity.ok(practicanteService.guardar(practicante));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Practicante> buscarPorId(@PathVariable(required = true) Integer id) {
        return ResponseEntity.ok(practicanteService.buscarPorId(id).get());
    }

    @PutMapping
    public ResponseEntity<Practicante> actualizar(@RequestBody Practicante practicante) {
        return ResponseEntity.ok(practicanteService.actualizar(practicante));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List<Practicante>> eliminar(@PathVariable(required = true) Integer id) {
        practicanteService.eliminar(id);
        return ResponseEntity.ok(practicanteService.listar());
    }
    @GetMapping("/auth/{authId}")
    public ResponseEntity<Practicante> getPracticanteByAuth(@PathVariable int authId) {
        Practicante practicante = practicanteRepository.findByAuth(authId);
        if (practicante != null) {
            return ResponseEntity.ok(practicante);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
