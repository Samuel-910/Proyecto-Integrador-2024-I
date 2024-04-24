package com.example.mscoordinador.service;

import com.example.mscoordinador.entity.Convocatoria;

import java.util.List;
import java.util.Optional;

public interface ConvocatoriaService {
    public List<Convocatoria> listar();

    public Convocatoria guardar(Convocatoria convocatoria);

    public Optional<Convocatoria> buscarPorId(Integer id);

    public Convocatoria actualizar(Convocatoria convocatoria);

    public void eliminar(Integer id);
}
