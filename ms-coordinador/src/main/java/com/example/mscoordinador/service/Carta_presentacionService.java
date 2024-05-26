package com.example.mscoordinador.service;

import com.example.mscoordinador.entity.Carta_presentacion;

import java.util.List;

public interface Carta_presentacionService {
    public List<Carta_presentacion> listar();

    public Carta_presentacion guardar(Carta_presentacion carta_presentacion);

    public Carta_presentacion buscarPorId(Integer id);

    public Carta_presentacion actualizar(Carta_presentacion carta_presentacion);

    public void eliminar(Integer id);
}
