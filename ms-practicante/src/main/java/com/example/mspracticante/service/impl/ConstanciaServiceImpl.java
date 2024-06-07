package com.example.mspracticante.service.impl;

import com.example.mspracticante.entity.Constancia;
import com.example.mspracticante.repository.ConstanciaRepository;
import com.example.mspracticante.service.ConstanciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
        if (constancia.getPracticante() == null || !constanciaRepository.existsById(constancia.getPracticante().getId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Practicante   con ID " + constancia.getPracticante().getId() + " no encontrada.");
        }
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
