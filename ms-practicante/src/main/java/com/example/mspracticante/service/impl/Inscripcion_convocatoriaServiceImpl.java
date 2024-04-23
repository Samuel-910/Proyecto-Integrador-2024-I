package com.example.mspracticante.service.impl;

import com.example.mspracticante.entity.Inscripcion_convocatoria;
import com.example.mspracticante.repository.Inscripcion_convocatoriaRepository;
import com.example.mspracticante.service.Inscripcion_convocatoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Inscripcion_convocatoriaServiceImpl implements Inscripcion_convocatoriaService {
    @Autowired

    Inscripcion_convocatoriaRepository inscripcion_convocatoriaRepository;

    @Override
    public List<Inscripcion_convocatoria> listar() {
        return inscripcion_convocatoriaRepository.findAll();
    }

    @Override
    public Inscripcion_convocatoria guardar(Inscripcion_convocatoria inscripcion_convocatoria) {
        return inscripcion_convocatoriaRepository.save(inscripcion_convocatoria);
    }

    @Override
    public Optional<Inscripcion_convocatoria> buscarPorId(Integer id) {
        return inscripcion_convocatoriaRepository.findById(id);
    }

    @Override
    public Inscripcion_convocatoria actualizar(Inscripcion_convocatoria inscripcion_convocatoria) {
        return inscripcion_convocatoriaRepository.save(inscripcion_convocatoria);
    }

    @Override
    public void eliminar(Integer id) {
        inscripcion_convocatoriaRepository.deleteById(id);

    }
}
