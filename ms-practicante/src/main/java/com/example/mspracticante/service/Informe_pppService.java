package com.example.mspracticante.service;

import com.example.mspracticante.entity.Informe_ppp;

import java.util.List;
import java.util.Optional;

public interface Informe_pppService {
    public List<Informe_ppp> listar();

    public Informe_ppp guardar(Informe_ppp informe_ppp);

    public Optional<Informe_ppp> buscarPorId(Integer id);

    public Informe_ppp actualizar(Informe_ppp informe_ppp);

    public void eliminar(Integer id);
}
