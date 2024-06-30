package com.example.mscoordinador.controller;

import com.example.mscoordinador.service.ConvenioService;
import com.example.mscoordinador.entity.Convenio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/convenio")
@CrossOrigin
public class ConvenioController {
    @Autowired
    private ConvenioService convenioService;

    @GetMapping
    public ResponseEntity<List<Convenio>> listar() {
        return ResponseEntity.ok(convenioService.listar());
    }

    @PostMapping
    public ResponseEntity<Convenio> guardar(@RequestBody Convenio convenio) {
        return ResponseEntity.ok(convenioService.guardar(convenio));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Convenio> buscarPorId(@PathVariable(required = true) Integer id) {
        return ResponseEntity.ok(convenioService.buscarPorId(id));
    }

    @PutMapping
    public ResponseEntity<Convenio> actualizar(@RequestBody Convenio convenio) {
        return ResponseEntity.ok(convenioService.actualizar(convenio));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List<Convenio>> eliminar(@PathVariable(required = true) Integer id) {
        convenioService.eliminar(id);
        return ResponseEntity.ok(convenioService.listar());
    }
}
