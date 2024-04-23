package com.example.mspracticante.controller;

import com.example.mspracticante.entity.Plan_ppp;
import com.example.mspracticante.service.Plan_pppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plan_ppp")
public class Plan_pppController {
    @Autowired
    private Plan_pppService plan_pppService;

    @GetMapping
    public ResponseEntity<List<Plan_ppp>> listar() {
        return ResponseEntity.ok(plan_pppService.listar());
    }

    @PostMapping
    public ResponseEntity<Plan_ppp> guardar(@RequestBody Plan_ppp plan_ppp) {
        return ResponseEntity.ok(plan_pppService.guardar(plan_ppp));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Plan_ppp> buscarPOrId(@PathVariable(required = true) Integer id) {
        return ResponseEntity.ok(plan_pppService.buscarPorId(id).get());
    }

    @PutMapping
    public ResponseEntity<Plan_ppp> actualizar(@RequestBody Plan_ppp plan_ppp) {
        return ResponseEntity.ok(plan_pppService.actualizar(plan_ppp));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List<Plan_ppp>> eliminar(@PathVariable(required = true) Integer id) {
        plan_pppService.eliminar(id);
        return ResponseEntity.ok(plan_pppService.listar());
    }
}
