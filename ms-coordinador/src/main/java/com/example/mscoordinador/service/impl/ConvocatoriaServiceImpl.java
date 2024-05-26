package com.example.mscoordinador.service.impl;

import com.example.mscoordinador.entity.Convocatoria;
import com.example.mscoordinador.repository.ConvocatoriaRepository;
import com.example.mscoordinador.service.ConvocatoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
        if (convocatoria.getEmpresa() == null || !convocatoriaRepository.existsById(convocatoria.getEmpresa().getId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Empresa con ID " + convocatoria.getEmpresa().getId() + " no encontrada.");
        }
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
