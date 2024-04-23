package com.example.mspracticante.service;

import com.example.mspracticante.entity.Carta_aceptacion;

import java.util.List;
import java.util.Optional;

public interface Carta_aceptacionService {
    public List<Carta_aceptacion> listar();

    public Carta_aceptacion guardar(Carta_aceptacion Carta_aceptacion);

    public Optional<Carta_aceptacion> buscarPorId(Integer id);

    public Carta_aceptacion actualizar(Carta_aceptacion Carta_aceptacion);

    public void eliminar(Integer id);
}
