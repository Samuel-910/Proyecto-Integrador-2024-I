package com.example.msconsejo.controller;


import com.example.msconsejo.entity.Informe_ppp;
import com.example.msconsejo.service.Informe_pppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/informe")
public class Informe_pppController {
    @Autowired
    private Informe_pppService informe_pppService;

    @GetMapping
    public ResponseEntity<List<Informe_ppp>> listar() {
        return ResponseEntity.ok(informe_pppService.listar());
    }

    @PostMapping
    public ResponseEntity<Informe_ppp> guardar(@RequestBody Informe_ppp informe_ppp) {
        return ResponseEntity.ok(informe_pppService.guardar(informe_ppp));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Informe_ppp> buscarPOrId(@PathVariable(required = true) Integer id) {
        return ResponseEntity.ok(informe_pppService.buscarPorId(id));
    }

    @PutMapping
    public ResponseEntity<Informe_ppp> actualizar(@RequestBody Informe_ppp informe_ppp) {
        return ResponseEntity.ok(informe_pppService.actualizar(informe_ppp));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List<Informe_ppp>> eliminar(@PathVariable(required = true) Integer id) {
        informe_pppService.eliminar(id);
        return ResponseEntity.ok(informe_pppService.listar());
    }
}
