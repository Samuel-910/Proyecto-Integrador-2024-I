package com.example.mssupervisor.service;

import com.example.mssupervisor.entity.Evaluacion;
import com.example.mssupervisor.entity.Roles;

import java.util.List;

public interface RolesService {
    public List<Roles> listar();

    public Roles guardar(Roles roles);

    public Roles buscarPorId(Integer id);

    public Roles actualizar(Roles roles);

    public void eliminar(Integer id);
}
