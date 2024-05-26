package com.example.mscoordinador.service;

import com.example.mscoordinador.entity.Coordinador;

import java.util.List;

public interface CoordinadorService {
    public List<Coordinador> listar();

    public Coordinador guardar(Coordinador coordinador);

    public Coordinador buscarPorId(Integer id);

    public Coordinador actualizar(Coordinador coordinador);

    public void eliminar(Integer id);
}
