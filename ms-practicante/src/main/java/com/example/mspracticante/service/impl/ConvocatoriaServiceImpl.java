package com.example.mspracticante.service.impl;

import com.example.msempresa.entity.Convocatoria;
import com.example.msempresa.repository.ConvocatoriaRepository;
import com.example.msempresa.service.ConvocatoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConvocatoriaServiceImpl implements ConvocatoriaService {
    @Autowired
    ConvocatoriaRepository convocatoriaRepository;
    @Override
    public List<Convocatoria> listar() {
        return convocatoriaRepository.findAll();
    }

    @Override
    public Convocatoria guardar(Convocatoria convocatoria) {
        return convocatoriaRepository.save(convocatoria);
    }

    @Override
    public Optional<Convocatoria> buscarPorId(Integer id) {
        return convocatoriaRepository.findById(id);
    }

    @Override
    public Convocatoria actualizar(Convocatoria convocatoria) {
        return convocatoriaRepository.save(convocatoria);
    }

    @Override
    public void eliminar(Integer id) {
        convocatoriaRepository.deleteById(id);

    }
}
