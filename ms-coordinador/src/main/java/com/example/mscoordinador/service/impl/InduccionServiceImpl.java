package com.example.mscoordinador.service.impl;

import com.example.mscoordinador.entity.Coordinador;
import com.example.mscoordinador.entity.Empresa;
import com.example.mscoordinador.entity.Induccion;
import com.example.mscoordinador.repository.CoordinadorRepository;
import com.example.mscoordinador.repository.EmpresaRepository;
import com.example.mscoordinador.repository.InduccionRepository;
import com.example.mscoordinador.service.InduccionService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class InduccionServiceImpl implements InduccionService {
    @Autowired
    InduccionRepository induccionRepository;

    @Override
    public List<Induccion> listar() {return induccionRepository.findAll();}

    @Override
    @Transactional
    public Induccion guardar(Induccion induccion) {
        if (induccion.getEmpresa() == null || !induccionRepository.existsById(induccion.getEmpresa().getId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Empresa   con ID " + induccion.getEmpresa().getId() + " no encontrada.");
        }
        if (induccion.getCoordinador() == null || !induccionRepository.existsById(induccion.getCoordinador().getId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Coordinador   con ID " + induccion.getCoordinador().getId() + " no encontrada.");
        }
        return induccionRepository.save(induccion);
    }
    @Override
    public Induccion buscarPorId(Integer id) {return induccionRepository.findById(id).orElse(null);}

    @Override
    public Induccion actualizar(Induccion induccion) {
        return induccionRepository.save(induccion);
    }

    @Override
    public void eliminar(Integer id) {
        induccionRepository.deleteById(id);

    }
}
