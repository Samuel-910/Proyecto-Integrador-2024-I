package com.example.mspracticante.service.impl;

import com.example.mspracticante.entity.Constancia;
import com.example.mspracticante.repository.ConstanciaRepository;
import com.example.mspracticante.service.ConstanciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConstanciaServiceImpl implements ConstanciaService {
    @Autowired
    ConstanciaRepository constanciaRepository;
    @Override
    public List<Constancia> listar() {
        return constanciaRepository.findAll();
    }

    @Override
    public Constancia guardar(Constancia constancia) {
        return constanciaRepository.save(constancia);
    }

    @Override
    public Optional<Constancia> buscarPorId(Integer id) {
        return constanciaRepository.findById(id);
    }

    @Override
    public Constancia actualizar(Constancia constancia) {
        return constanciaRepository.save(constancia);
    }

    @Override
    public void eliminar(Integer id) {
        constanciaRepository.deleteById(id);

    }
}
