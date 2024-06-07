package com.example.msconsejo.service;

import com.example.msconsejo.entity.Informe;

import java.util.List;
import java.util.Optional;

public interface InformeService {
    public List<Informe> listar();

    public Informe guardar(Informe informe);

    public Informe buscarPorId(Integer id);

    public Informe actualizar(Informe informe);

    public void eliminar(Integer id);
}
