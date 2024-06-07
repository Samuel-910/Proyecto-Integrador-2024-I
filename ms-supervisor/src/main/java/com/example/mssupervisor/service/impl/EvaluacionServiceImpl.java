package com.example.mssupervisor.service.impl;

import com.example.mssupervisor.entity.Evaluacion;
import com.example.mssupervisor.feign.PracticanteFeign;
import com.example.mssupervisor.repository.EvaluacionRepository;
import com.example.mssupervisor.repository.SupervisorRepository;
import com.example.mssupervisor.service.EvaluacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class EvaluacionServiceImpl implements EvaluacionService {
    @Autowired
    EvaluacionRepository evaluacionRepository;

    @Autowired
    private PracticanteFeign practicanteFeign;

    @Override
    public List<Evaluacion> listar() {

        List<Evaluacion> evaluacions = evaluacionRepository.findAll();

        evaluacions.forEach(evaluacion -> {
            evaluacion.setPracticanteDto(practicanteFeign.buscarPorId(evaluacion.getPracticanteId()).getBody());
        });

        return evaluacions;
    }

    @Override
    public Evaluacion guardar(Evaluacion evaluacion) {
        if (evaluacion.getSupervisor() == null || !evaluacionRepository.existsById(evaluacion.getSupervisor().getId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Supervisor   con ID " + evaluacion.getSupervisor().getId() + " no encontrada.");
        }
        ResponseEntity<?> response = practicanteFeign.buscarPorId(evaluacion.getPracticanteId());
        if (response.getStatusCode().is4xxClientError()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Practicante con ID " + evaluacion.getPracticanteId() + " no encontrado.");
        }
        return evaluacionRepository.save(evaluacion);
    }

    @Override
    public Evaluacion buscarPorId(Integer id) {

        Evaluacion evaluacion = evaluacionRepository.findById(id).get();
        evaluacion.setPracticanteDto(practicanteFeign.buscarPorId(evaluacion.getPracticanteId()).getBody());
        return evaluacion;
    }

    @Override
    public Evaluacion actualizar(Evaluacion evaluacion) {
        return evaluacionRepository.save(evaluacion);
    }

    @Override
    public void eliminar(Integer id) {
        evaluacionRepository.deleteById(id);

    }
}
