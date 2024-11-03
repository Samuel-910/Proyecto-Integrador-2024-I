package com.example.mspracticante.service;

import com.example.mspracticante.entity.Inscripcion_convocatoria;

import java.util.List;

public interface Inscripcion_convocatoriaService {
    public List<Inscripcion_convocatoria> listar();

    public Inscripcion_convocatoria guardar(Inscripcion_convocatoria inscripcion_convocatoria);

    public Inscripcion_convocatoria buscarPorId(Integer id);

    public Inscripcion_convocatoria actualizar(Inscripcion_convocatoria inscripcion_convocatoria);

    public void eliminar(Integer id);

}
