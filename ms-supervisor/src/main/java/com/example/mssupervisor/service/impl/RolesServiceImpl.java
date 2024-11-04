package com.example.mssupervisor.service.impl;

import com.example.mssupervisor.entity.Roles;
import com.example.mssupervisor.repository.RolesRepository;
import com.example.mssupervisor.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class RolesServiceImpl implements RolesService {

    @Autowired
    private RolesRepository rolesRepository;

    @Override
    public List<Roles> listar() {
        return rolesRepository.findAll();
    }

    @Override
    public Roles guardar(Roles role) {
        return rolesRepository.save(role);
    }

    @Override
    public Roles buscarPorId(Integer id) {
        return rolesRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Rol con ID " + id + " no encontrado."));
    }

    @Override
    public Roles actualizar(Roles role) {
        if (!rolesRepository.existsById(role.getId())) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Rol con ID " + role.getId() + " no encontrado.");
        }
        return rolesRepository.save(role);
    }

    @Override
    public void eliminar(Integer id) {
        if (!rolesRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Rol con ID " + id + " no encontrado.");
        }
        rolesRepository.deleteById(id);
    }
}
