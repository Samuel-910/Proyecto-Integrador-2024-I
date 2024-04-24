package com.example.mscoordinador.service;

import com.example.mscoordinador.entity.Empresa;

import java.util.List;
import java.util.Optional;

public interface EmpresaService {
    public List<Empresa> listar();

    public Empresa guardar(Empresa empresa);

    public Optional<Empresa> buscarPorId(Integer id);

    public Empresa actualizar(Empresa empresa);

    public void eliminar(Integer id);
}
