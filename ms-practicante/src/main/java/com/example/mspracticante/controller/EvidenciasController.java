package com.example.mspracticante.controller;

import com.example.mspracticante.entity.Evidencias;
import com.example.mspracticante.service.EvidenciasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/evidencias")
@CrossOrigin(origins = "http://localhost:4200")
public class EvidenciasController {

    @Autowired
    private EvidenciasService evidenciasService;

    @GetMapping
    public ResponseEntity<List<Evidencias>> listar() {
        List<Evidencias> evidencias = evidenciasService.listar();
        return new ResponseEntity<>(evidencias, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Evidencias> obtenerPorId(@PathVariable("id") Integer id) {
        Optional<Evidencias> evidencia = evidenciasService.buscarPorId(id);
        if (evidencia.isPresent()) {
            return new ResponseEntity<>(evidencia.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Evidencias> crear(@RequestBody Evidencias evidencia) {
        Evidencias nuevaEvidencia = evidenciasService.guardar(evidencia);
        return new ResponseEntity<>(nuevaEvidencia, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Evidencias> actualizar(@PathVariable("id") Integer id, @RequestBody Evidencias evidencia) {
        Optional<Evidencias> evidenciaExistente = evidenciasService.buscarPorId(id);
        if (evidenciaExistente.isPresent()) {
            evidencia.setId(id);
            Evidencias evidenciaActualizada = evidenciasService.actualizar(id, evidencia);
            return new ResponseEntity<>(evidenciaActualizada, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) {
        Optional<Evidencias> evidenciaExistente = evidenciasService.buscarPorId(id);
        if (evidenciaExistente.isPresent()) {
            evidenciasService.eliminar(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
