package com.example.mscoordinador.service;

import com.example.mscoordinador.entity.Empresa;

import java.util.List;

public interface EmpresaService {
    public List<Empresa> listar();

    public Empresa guardar(Empresa empresa);

    public Empresa buscarPorId(Integer id);

    public Empresa actualizar(Integer id, Empresa empresa);

    public void eliminar(Integer id);
}
