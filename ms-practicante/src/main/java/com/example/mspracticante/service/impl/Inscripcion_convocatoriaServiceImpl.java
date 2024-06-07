package com.example.mspracticante.service.impl;

import com.example.mspracticante.entity.Inscripcion_convocatoria;
import com.example.mspracticante.feign.ConvocatoriaFeign;
import com.example.mspracticante.repository.Inscripcion_convocatoriaRepository;
import com.example.mspracticante.service.Inscripcion_convocatoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class Inscripcion_convocatoriaServiceImpl implements Inscripcion_convocatoriaService {
    @Autowired
    Inscripcion_convocatoriaRepository inscripcion_convocatoriaRepository;

    @Autowired
    private ConvocatoriaFeign convocatoriaFeign;

    @Override
    public List<Inscripcion_convocatoria> listar() {
        List<Inscripcion_convocatoria> Inscripcion_convocatorias = inscripcion_convocatoriaRepository.findAll();

        Inscripcion_convocatorias.forEach(Inscripcion_convocatoria -> {
            Inscripcion_convocatoria.setConvocatoriaDto(convocatoriaFeign.buscarPOrId(Inscripcion_convocatoria.getConvocatoriaId()).getBody());
        });
        return Inscripcion_convocatorias;
    }

    @Override
    public Inscripcion_convocatoria guardar(Inscripcion_convocatoria inscripcion_convocatoria) {
        if (inscripcion_convocatoria.getPracticante() == null || !inscripcion_convocatoriaRepository.existsById(inscripcion_convocatoria.getPracticante().getId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Practicante   con ID " + inscripcion_convocatoria.getPracticante().getId() + " no encontrada.");
        }
        ResponseEntity<?> response = convocatoriaFeign.buscarPOrId(inscripcion_convocatoria.getConvocatoriaId());
        if (response.getStatusCode().is4xxClientError()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Convocatoria con ID " + inscripcion_convocatoria.getConvocatoriaId() + " no encontrado.");
        }
        return inscripcion_convocatoriaRepository.save(inscripcion_convocatoria);
    }

    @Override
    public Inscripcion_convocatoria buscarPorId(Integer id) {
        Inscripcion_convocatoria inscripcion_convocatoria = inscripcion_convocatoriaRepository.findById(id).get();
        inscripcion_convocatoria.setConvocatoriaDto(convocatoriaFeign.buscarPOrId(inscripcion_convocatoria.getConvocatoriaId()).getBody());
        return inscripcion_convocatoria;
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
