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
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InduccionServiceImpl implements InduccionService {
    @Autowired
    InduccionRepository induccionRepository;
    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private CoordinadorRepository coordinadorRepository;

    @Override
    public List<Induccion> listar() {return induccionRepository.findAll();}

    @Override
    @Transactional
    public Induccion guardar(Induccion induccion) {
        verificarExistenciaDeEmpresa(induccion.getEmpresa());
        verificarExistenciaDeCoordinador(induccion.getCoordinador());
        return induccionRepository.save(induccion);
    }

    private void verificarExistenciaDeEmpresa(Empresa empresa) {
        if (empresa == null || empresa.getId() == null || !empresaRepository.existsById(empresa.getId())) {
            throw new RuntimeException("Empresa no proporcionada o con ID no encontrado.");
        }
    }

    private void verificarExistenciaDeCoordinador(Coordinador coordinador) {
        if (coordinador == null || coordinador.getId() == null || !coordinadorRepository.existsById(coordinador.getId())) {
            throw new RuntimeException("Coordinador no proporcionado o con ID no encontrado.");
        }
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
