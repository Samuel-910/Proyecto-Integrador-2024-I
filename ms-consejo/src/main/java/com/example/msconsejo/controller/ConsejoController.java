package com.example.msconsejo.controller;

import com.example.msconsejo.entity.ConsejoEP;
import com.example.msconsejo.service.ConsejoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consejo")
public class ConsejoController {
    @Autowired
    private ConsejoService consejoService;

    @GetMapping
    public ResponseEntity<List<ConsejoEP>> listar() {
        return ResponseEntity.ok(consejoService.listar());
    }

    @PostMapping
    public ResponseEntity<ConsejoEP> guardar(@RequestBody ConsejoEP consejoEP) {
        return ResponseEntity.ok(consejoService.guardar(consejoEP));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsejoEP> buscarPOrId(@PathVariable(required = true) Integer id) {
        return ResponseEntity.ok(consejoService.buscarPorId(id).get());
    }

    @PutMapping
    public ResponseEntity<ConsejoEP> actualizar(@RequestBody ConsejoEP consejoEP) {
        return ResponseEntity.ok(consejoService.actualizar(consejoEP));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List<ConsejoEP>> eliminar(@PathVariable(required = true) Integer id) {
        consejoService.eliminar(id);
        return ResponseEntity.ok(consejoService.listar());
    }
}
