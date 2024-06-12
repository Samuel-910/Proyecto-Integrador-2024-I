package com.example.mscoordinador.service;

import com.example.mscoordinador.entity.Convocatoria;

import java.util.List;

public interface ConvocatoriaService {
    public List<Convocatoria> listar();

    public Convocatoria guardar(Convocatoria convocatoria);

    public Convocatoria buscarPorId(Integer id);

    public Convocatoria actualizar(Convocatoria convocatoria);

    public void eliminar(Integer id);
}
