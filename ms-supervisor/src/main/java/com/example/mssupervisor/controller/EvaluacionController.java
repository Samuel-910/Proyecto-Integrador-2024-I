package com.example.mssupervisor.controller;

import com.example.mssupervisor.entity.Evaluacion;
import com.example.mssupervisor.service.EvaluacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/evaluacion")
public class EvaluacionController {
    @Autowired
    private EvaluacionService evaluacionService;

    @GetMapping
    public ResponseEntity<List<Evaluacion>> listar() {
        return ResponseEntity.ok(evaluacionService.listar());
    }

    @PostMapping
    public ResponseEntity<Evaluacion> guardar(@RequestBody Evaluacion evaluacion) {
        return ResponseEntity.ok(evaluacionService.guardar(evaluacion));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Evaluacion> buscarPorId(@PathVariable(required = true) Integer id) {
        return ResponseEntity.ok(evaluacionService.buscarPorId(id));
    }

    @PutMapping
    public ResponseEntity<Evaluacion> actualizar(@RequestBody Evaluacion evaluacion) {
        return ResponseEntity.ok(evaluacionService.actualizar(evaluacion));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List<Evaluacion>> eliminar(@PathVariable(required = true) Integer id) {
        evaluacionService.eliminar(id);
        return ResponseEntity.ok(evaluacionService.listar());
    }
}
