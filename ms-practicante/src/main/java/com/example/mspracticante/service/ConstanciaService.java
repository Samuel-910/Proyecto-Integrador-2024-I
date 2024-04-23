package com.example.mspracticante.service;

import com.example.mspracticante.entity.Constancia;

import java.util.List;
import java.util.Optional;

public interface ConstanciaService {
    public List<Constancia> listar();

    public Constancia guardar(Constancia constancia);

    public Optional<Constancia> buscarPorId(Integer id);

    public Constancia actualizar(Constancia constancia);

    public void eliminar(Integer id);
}
