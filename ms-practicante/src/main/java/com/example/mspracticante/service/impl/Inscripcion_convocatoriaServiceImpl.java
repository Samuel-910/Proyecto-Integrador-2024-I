package com.example.mspracticante.service.impl;

import com.example.mspracticante.dto.ConvocatoriaDto;
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
    private Inscripcion_convocatoriaRepository inscripcion_convocatoriaRepository;

    @Autowired
    private ConvocatoriaFeign convocatoriaFeign;

    @Override
    public List<Inscripcion_convocatoria> listar() {
        List<Inscripcion_convocatoria> inscripciones = inscripcion_convocatoriaRepository.findAll();

        inscripciones.forEach(inscripcion -> {
            try {
                ResponseEntity<ConvocatoriaDto> response = convocatoriaFeign.buscarPOrId(inscripcion.getConvocatoriaId());
                if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
                    inscripcion.setConvocatoriaDto(response.getBody());
                } else {
                    inscripcion.setConvocatoriaDto(getFallbackConvocatoriaDto(inscripcion.getConvocatoriaId()));
                }
            } catch (Exception e) {
                // En caso de error, asignar un valor por defecto (fallback)
                inscripcion.setConvocatoriaDto(getFallbackConvocatoriaDto(inscripcion.getConvocatoriaId()));
            }
        });
        return inscripciones;
    }

    @Override
    public Inscripcion_convocatoria guardar(Inscripcion_convocatoria inscripcion) {
        return inscripcion_convocatoriaRepository.save(inscripcion);
    }

    @Override
    public Inscripcion_convocatoria buscarPorId(Integer id) {
        Inscripcion_convocatoria inscripcion = inscripcion_convocatoriaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Inscripción no encontrada"));

        try {
            ResponseEntity<ConvocatoriaDto> response = convocatoriaFeign.buscarPOrId(inscripcion.getConvocatoriaId());
            if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
                inscripcion.setConvocatoriaDto(response.getBody());
            } else {
                inscripcion.setConvocatoriaDto(getFallbackConvocatoriaDto(inscripcion.getConvocatoriaId()));
            }
        } catch (Exception e) {
            // Asignar un valor por defecto (fallback) si ocurre un error
            inscripcion.setConvocatoriaDto(getFallbackConvocatoriaDto(inscripcion.getConvocatoriaId()));
        }

        return inscripcion;
    }

    @Override
    public Inscripcion_convocatoria actualizar(Integer id, Inscripcion_convocatoria inscripcion) {
        // Buscar la inscripción existente en la base de datos
        Inscripcion_convocatoria inscripcionFromDb = buscarPorId(id);
        // Actualizar los campos primitivos
        inscripcionFromDb.setInscripcionEstado(inscripcion.getInscripcionEstado());
        inscripcionFromDb.setInscripcionGanador(inscripcion.getInscripcionGanador());
        inscripcionFromDb.setConvocatoriaId(inscripcion.getConvocatoriaId());
        // Comprueba si la inscripción existe antes de actualizarla
        if (!inscripcion_convocatoriaRepository.existsById(inscripcion.getId())) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Inscripción no encontrada");
        }
        // Guardar los cambios en el repositorio
        return inscripcion_convocatoriaRepository.save(inscripcionFromDb);
    }

    @Override
    public void eliminar(Integer id) {
        // Comprueba si la inscripción existe antes de eliminarla
        if (!inscripcion_convocatoriaRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Inscripción no encontrada");
        }
        inscripcion_convocatoriaRepository.deleteById(id);
    }

    private ConvocatoriaDto getFallbackConvocatoriaDto(Integer convocatoriaId) {
        ConvocatoriaDto fallback = new ConvocatoriaDto();
        fallback.setId(convocatoriaId);
        fallback.setTitulo("No disponible");
        fallback.setDescripcion("Información no disponible temporalmente");
        return fallback;
    }
}
