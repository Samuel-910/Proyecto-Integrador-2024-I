package com.example.msconsejo.controller;


import com.example.msconsejo.entity.Informe;
import com.example.msconsejo.entity.Revision;
import com.example.msconsejo.service.InformeService;
import com.example.msconsejo.service.RevisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/informe")
public class InformeController {
    @Autowired
    private InformeService informeService;

    @GetMapping
    public ResponseEntity<List<Informe>> listar() {
        return ResponseEntity.ok(informeService.listar());
    }

    @PostMapping
    public ResponseEntity<Informe> guardar(@RequestBody Informe informe) {
        return ResponseEntity.ok(informeService.guardar(informe));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Informe> buscarPOrId(@PathVariable(required = true) Integer id) {
        return ResponseEntity.ok(informeService.buscarPorId(id));
    }

    @PutMapping
    public ResponseEntity<Informe> actualizar(@RequestBody Informe informe) {
        return ResponseEntity.ok(informeService.actualizar(informe));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List<Informe>> eliminar(@PathVariable(required = true) Integer id) {
        informeService.eliminar(id);
        return ResponseEntity.ok(informeService.listar());
    }
}
