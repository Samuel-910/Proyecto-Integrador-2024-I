package com.example.mspracticante.service.impl;

import com.example.mspracticante.entity.Carta_aceptacion;
import com.example.mspracticante.repository.Carta_aceptacionRepository;
import com.example.mspracticante.service.Carta_aceptacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Carta_aceptacionServiceImpl implements Carta_aceptacionService {
    @Autowired
    Carta_aceptacionRepository carta_aceptacionRepository;
    @Override
    public List<Carta_aceptacion> listar() {
        return carta_aceptacionRepository.findAll();
    }

    @Override
    public Carta_aceptacion guardar(Carta_aceptacion carta_aceptacion) {
        return carta_aceptacionRepository.save(carta_aceptacion);
    }

    @Override
    public Optional<Carta_aceptacion> buscarPorId(Integer id) {
        return carta_aceptacionRepository.findById(id);
    }

    @Override
    public Carta_aceptacion actualizar(Carta_aceptacion carta_aceptacion) {
        return carta_aceptacionRepository.save(carta_aceptacion);
    }

    @Override
    public void eliminar(Integer id) {
        carta_aceptacionRepository.deleteById(id);

    }
}
