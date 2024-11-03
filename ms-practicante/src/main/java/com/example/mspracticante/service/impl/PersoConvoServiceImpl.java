package com.example.mspracticante.service.impl;

import com.example.mspracticante.dto.ConvocatoriaDto;
import com.example.mspracticante.entity.Inscripcion_convocatoria;
import com.example.mspracticante.entity.PersoConvo;
import com.example.mspracticante.feign.ConvocatoriaFeign;
import com.example.mspracticante.repository.Inscripcion_convocatoriaRepository;
import com.example.mspracticante.repository.persoconvoRepository;
import com.example.mspracticante.service.Inscripcion_convocatoriaService;
import com.example.mspracticante.service.PersoConvoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class PersoConvoServiceImpl implements PersoConvoService {

    @Autowired
    private persoconvoRepository persoConvoRepository;

    @Override
    public List<PersoConvo> listar() {
        return persoConvoRepository.findAll();
    }

    @Override
    public PersoConvo guardar(PersoConvo persoConvo) {
        return persoConvoRepository.save(persoConvo);
    }

    @Override
    public PersoConvo buscarPorId(Integer id) {
        Optional<PersoConvo> optionalPersoConvo = persoConvoRepository.findById(id);
        if (optionalPersoConvo.isPresent()) {
            return optionalPersoConvo.get();
        } else {
            throw new RuntimeException("PersoConvo no encontrado con id: " + id);
        }
    }

    @Override
    public PersoConvo actualizar(PersoConvo persoConvo) {
        if (persoConvo.getId() == null || !persoConvoRepository.existsById(persoConvo.getId())) {
            throw new RuntimeException("PersoConvo no encontrado con id: " + persoConvo.getId());
        }
        return persoConvoRepository.save(persoConvo);
    }

    @Override
    public void eliminar(Integer id) {
        if (!persoConvoRepository.existsById(id)) {
            throw new RuntimeException("PersoConvo no encontrado con id: " + id);
        }
        persoConvoRepository.deleteById(id);
    }
}
