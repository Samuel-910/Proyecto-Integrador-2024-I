package com.example.mscoordinador.service;

import com.example.mscoordinador.entity.Convenio;

import java.util.List;
import java.util.Optional;

public interface ConvenioService {
    public List<Convenio> listar();

    public Convenio guardar(Convenio convenio);

    public Optional<Convenio> buscarPorId(Integer id);

    public Convenio actualizar(Convenio convenio);

    public void eliminar(Integer id);
}
