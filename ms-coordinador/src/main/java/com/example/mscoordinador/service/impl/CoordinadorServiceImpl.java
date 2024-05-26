package com.example.mscoordinador.service.impl;

import com.example.mscoordinador.entity.Convenio;
import com.example.mscoordinador.entity.Coordinador;
import com.example.mscoordinador.entity.Empresa;
import com.example.mscoordinador.feign.PracticanteFeign;
import com.example.mscoordinador.repository.ConvenioRepository;
import com.example.mscoordinador.repository.CoordinadorRepository;
import com.example.mscoordinador.repository.EmpresaRepository;
import com.example.mscoordinador.service.ConvenioService;
import com.example.mscoordinador.service.CoordinadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CoordinadorServiceImpl implements CoordinadorService {
    @Autowired
    CoordinadorRepository coordinadorRepository;
    @Override
    public List<Coordinador> listar() {
        return coordinadorRepository.findAll();
    }

    @Override
    public Coordinador guardar(Coordinador coordinador) {
        return coordinadorRepository.save(coordinador);
    }

    @Override
    public Coordinador buscarPorId(Integer id) {
        return coordinadorRepository.findById(id).orElse(null);
    }

    @Override
    public Coordinador actualizar(Coordinador coordinador) {
        return coordinadorRepository.save(coordinador);
    }

    @Override
    public void eliminar(Integer id) {
        coordinadorRepository.deleteById(id);

    }
}
