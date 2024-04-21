package com.example.msempresa.service;

import com.example.msempresa.entity.Empresa;

import java.util.List;
import java.util.Optional;

public interface EmpresaService {
    public List<Empresa> listar();

    public Empresa guardar(Empresa empresa);

    public Optional<Empresa> buscarPorId(Integer id);

    public Empresa actualizar(Empresa empresa);

    public void eliminar(Integer id);
}
