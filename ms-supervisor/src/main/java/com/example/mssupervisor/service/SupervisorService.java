package com.example.mssupervisor.service;

import com.example.mssupervisor.entity.Supervisor;

import java.util.List;
import java.util.Optional;

public interface SupervisorService {
    public List<Supervisor> listar();

    public Supervisor guardar(Supervisor supervisor);

    public Optional<Supervisor> buscarPorId(Integer id);

    public Supervisor actualizar(Supervisor supervisor);

    public void eliminar(Integer id);
}
