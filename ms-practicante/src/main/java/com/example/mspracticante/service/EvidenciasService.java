package com.example.mspracticante.service;

import com.example.mspracticante.entity.Evidencias;

import java.util.List;
import java.util.Optional;

public interface EvidenciasService {
    public List<Evidencias> listar();

    public Evidencias guardar(Evidencias Evidencias);

    public Optional<Evidencias> buscarPorId(Integer id);

    public Evidencias actualizar(Integer id,Evidencias Evidencias);

    public void eliminar(Integer id);
}
