package com.example.mscoordinador.service;

import com.example.mscoordinador.entity.Induccion;

import java.util.List;

public interface InduccionService {
    public List<Induccion> listar();

    public Induccion guardar(Induccion induccion);

    public Induccion buscarPorId(Integer id);

    public Induccion actualizar(Induccion induccion);

    public void eliminar(Integer id);
}
