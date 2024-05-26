package com.example.msconsejo.service;

import com.example.msconsejo.entity.Revision;
import java.util.List;
import java.util.Optional;

public interface RevisionService {
    public List<Revision> listar();

    public Revision guardar(Revision revision);

    public Optional<Revision> buscarPorId(Integer id);

    public Revision actualizar(Revision revision);

    public void eliminar(Integer id);
}
