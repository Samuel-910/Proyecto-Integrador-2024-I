package com.example.msconsejo.service;

import com.example.msconsejo.entity.ConsejoEP;

import java.util.List;
import java.util.Optional;

public interface ConsejoService {
    public List<ConsejoEP> listar();

    public ConsejoEP guardar(ConsejoEP consejoEP);

    public Optional<ConsejoEP> buscarPorId(Integer id);

    public ConsejoEP actualizar(ConsejoEP consejoEP);

    public void eliminar(Integer id);
}
