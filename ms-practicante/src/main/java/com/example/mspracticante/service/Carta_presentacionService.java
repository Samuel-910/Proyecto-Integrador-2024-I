package com.example.mspracticante.service;

import com.example.mspracticante.entity.Carta_presentacion;

import java.util.List;
import java.util.Optional;

public interface Carta_presentacionService {
    public List<Carta_presentacion> listar();

    public Carta_presentacion guardar(Carta_presentacion carta_presentacion);

    public Optional<Carta_presentacion> buscarPorId(Integer id);

    public Carta_presentacion actualizar(Carta_presentacion carta_presentacion);

    public void eliminar(Integer id);
}
