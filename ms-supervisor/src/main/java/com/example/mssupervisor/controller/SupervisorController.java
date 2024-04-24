package com.example.mssupervisor.controller;

import com.example.mssupervisor.entity.Supervisor;
import com.example.mssupervisor.service.SupervisorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/supervisor")
public class SupervisorController {
    @Autowired
    private SupervisorService supervisorService;

    @GetMapping
    public ResponseEntity<List<Supervisor>> listar() {
        return ResponseEntity.ok(supervisorService.listar());
    }

    @PostMapping
    public ResponseEntity<Supervisor> guardar(@RequestBody Supervisor supervisor) {
        return ResponseEntity.ok(supervisorService.guardar(supervisor));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Supervisor> buscarPOrId(@PathVariable(required = true) Integer id) {
        return ResponseEntity.ok(supervisorService.buscarPorId(id).get());
    }

    @PutMapping
    public ResponseEntity<Supervisor> actualizar(@RequestBody Supervisor supervisor) {
        return ResponseEntity.ok(supervisorService.actualizar(supervisor));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List<Supervisor>> eliminar(@PathVariable(required = true) Integer id) {
        supervisorService.eliminar(id);
        return ResponseEntity.ok(supervisorService.listar());
    }
}
