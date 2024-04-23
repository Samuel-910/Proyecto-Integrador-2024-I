package com.example.mspracticante.service;

import com.example.mspracticante.entity.Plan_ppp;

import java.util.List;
import java.util.Optional;

public interface Plan_pppService {
    public List<Plan_ppp> listar();

    public Plan_ppp guardar(Plan_ppp plan_ppp);

    public Optional<Plan_ppp> buscarPorId(Integer id);

    public Plan_ppp actualizar(Plan_ppp plan_ppp);

    public void eliminar(Integer id);
}
