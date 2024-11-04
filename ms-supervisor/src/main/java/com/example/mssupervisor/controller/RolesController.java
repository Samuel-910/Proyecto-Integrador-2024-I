package com.example.mssupervisor.controller;

import com.example.mssupervisor.entity.Roles;
import com.example.mssupervisor.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RolesController {

    @Autowired
    private RolesService rolesService;

    // Listar todos los roles
    @GetMapping
    public ResponseEntity<List<Roles>> listarRoles() {
        List<Roles> roles = rolesService.listar();
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }

    // Crear un nuevo rol
    @PostMapping
    public ResponseEntity<Roles> crearRol(@RequestBody Roles role) {
        Roles nuevoRol = rolesService.guardar(role);
        return new ResponseEntity<>(nuevoRol, HttpStatus.CREATED);
    }

    // Buscar un rol por ID
    @GetMapping("/{id}")
    public ResponseEntity<Roles> buscarRolPorId(@PathVariable Integer id) {
        Roles role = rolesService.buscarPorId(id);
        return new ResponseEntity<>(role, HttpStatus.OK);
    }

    // Actualizar un rol existente
    @PutMapping("/{id}")
    public ResponseEntity<Roles> actualizarRol(@PathVariable Integer id, @RequestBody Roles role) {
        // Establecer el ID del rol recibido en el ID del parámetro para asegurar que se actualiza el correcto
        role.setId(id);
        Roles rolActualizado = rolesService.actualizar(role);
        return new ResponseEntity<>(rolActualizado, HttpStatus.OK);
    }

    // Eliminar un rol por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarRol(@PathVariable Integer id) {
        rolesService.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
