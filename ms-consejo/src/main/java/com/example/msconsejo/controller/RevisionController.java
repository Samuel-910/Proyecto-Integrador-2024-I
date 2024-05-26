package com.example.msconsejo.controller;


import com.example.msconsejo.entity.Informe_ppp;
import com.example.msconsejo.entity.Revision;
import com.example.msconsejo.service.Informe_pppService;
import com.example.msconsejo.service.RevisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/revision")
public class RevisionController {
    @Autowired
    private RevisionService revisionService;

    @GetMapping
    public ResponseEntity<List<Revision>> listar() {
        return ResponseEntity.ok(revisionService.listar());
    }

    @PostMapping
    public ResponseEntity<Revision> guardar(@RequestBody Revision revision) {
        return ResponseEntity.ok(revisionService.guardar(revision));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Revision> buscarPOrId(@PathVariable(required = true) Integer id) {
        return ResponseEntity.ok(revisionService.buscarPorId(id).get());
    }

    @PutMapping
    public ResponseEntity<Revision> actualizar(@RequestBody Revision revision) {
        return ResponseEntity.ok(revisionService.actualizar(revision));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List<Revision>> eliminar(@PathVariable(required = true) Integer id) {
        revisionService.eliminar(id);
        return ResponseEntity.ok(revisionService.listar());
    }
}
