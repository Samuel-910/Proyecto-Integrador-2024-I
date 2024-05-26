package com.example.mspracticante.service.impl;

import com.example.mspracticante.entity.Carta_presentacion;
import com.example.mspracticante.repository.Carta_presentacionRepository;
import com.example.mspracticante.service.Carta_presentacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class Carta_presentacionServiceImpl implements Carta_presentacionService {
    @Autowired

    Carta_presentacionRepository carta_presentacionRepository;

    @Override
    public List<Carta_presentacion> listar() {
        return carta_presentacionRepository.findAll();
    }

    @Override
    public Carta_presentacion guardar(Carta_presentacion carta_presentacion) {
        if (carta_presentacion.getPracticante() == null || !carta_presentacionRepository.existsById(carta_presentacion.getPracticante().getId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Practicante con ID " + carta_presentacion.getPracticante().getId() + " no encontrada.");
        }
        return carta_presentacionRepository.save(carta_presentacion);
    }

    @Override
    public Optional<Carta_presentacion> buscarPorId(Integer id) {
        return carta_presentacionRepository.findById(id);
    }

    @Override
    public Carta_presentacion actualizar(Carta_presentacion carta_presentacion) {
        return carta_presentacionRepository.save(carta_presentacion);
    }

    @Override
    public void eliminar(Integer id) {
        carta_presentacionRepository.deleteById(id);

    }
}
