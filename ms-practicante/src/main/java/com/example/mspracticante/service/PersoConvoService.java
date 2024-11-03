package com.example.mspracticante.service;

import com.example.mspracticante.entity.PersoConvo;

import java.util.List;

public interface PersoConvoService {
    public List<PersoConvo> listar();

    public PersoConvo guardar(PersoConvo persoConvo);

    public PersoConvo buscarPorId(Integer id);

    public PersoConvo actualizar(PersoConvo PersoConvo);

    public void eliminar(Integer id);

}
