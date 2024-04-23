package com.example.mspracticante.service.impl;

import com.example.mspracticante.entity.Practicante;
import com.example.mspracticante.repository.PracticanteRepository;
import com.example.mspracticante.service.PracticanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PracticanteServiceImpl implements PracticanteService {
    @Autowired
    PracticanteRepository practicanteRepository;
    @Override
    public List<Practicante> listar() {
        return practicanteRepository.findAll();
    }

    @Override
    public Practicante guardar(Practicante practicante) {
        return practicanteRepository.save(practicante);
    }

    @Override
    public Optional<Practicante> buscarPorId(Integer id) {
        return practicanteRepository.findById(id);
    }

    @Override
    public Practicante actualizar(Practicante practicante) {
        return practicanteRepository.save(practicante);
    }

    @Override
    public void eliminar(Integer id) {
        practicanteRepository.deleteById(id);

    }
}
