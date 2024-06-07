package com.example.mssupervisor.service;

import com.example.mssupervisor.entity.Evaluacion;
import java.util.List;

public interface EvaluacionService {
    public List<Evaluacion> listar();

    public Evaluacion guardar(Evaluacion evaluacion);

    public Evaluacion buscarPorId(Integer id);

    public Evaluacion actualizar(Evaluacion evaluacion);

    public void eliminar(Integer id);
}
