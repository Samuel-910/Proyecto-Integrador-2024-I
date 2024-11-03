package com.example.mscoordinador.controller;

import com.example.mscoordinador.entity.Empresa;
import com.example.mscoordinador.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/empresa")
public class EmpresaController {
    @Autowired
    private EmpresaService empresaService;

    @GetMapping
    public ResponseEntity<List<Empresa>> listar() {
        return ResponseEntity.ok(empresaService.listar());
    }

    @PostMapping
    public ResponseEntity<Empresa> guardar(@RequestBody Empresa empresa) {
        return ResponseEntity.ok(empresaService.guardar(empresa));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empresa> buscarPOrId(@PathVariable(required = true) Integer id) {
        return ResponseEntity.ok(empresaService.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Empresa> actualizar(@PathVariable(required = true) Integer id,@RequestBody Empresa empresa) {
        return ResponseEntity.ok(empresaService.actualizar(id,empresa));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List<Empresa>> eliminar(@PathVariable(required = true) Integer id) {
        empresaService.eliminar(id);
        return ResponseEntity.ok(empresaService.listar());
    }
}
