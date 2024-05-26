package com.example.mscoordinador.service.impl;

import com.example.mscoordinador.entity.Coordinador;
import com.example.mscoordinador.entity.Empresa;
import com.example.mscoordinador.entity.Induccion;
import com.example.mscoordinador.repository.CoordinadorRepository;
import com.example.mscoordinador.repository.EmpresaRepository;
import com.example.mscoordinador.repository.InduccionRepository;
import com.example.mscoordinador.service.InduccionService;
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
    public Induccion guardar(Induccion induccion) {

        // Verificar existencia de Coordinador y Empresa
        Optional<Coordinador> coordinador = coordinadorRepository.findById(induccion.getCoordinador().getId());
        Optional<Empresa> empresa = empresaRepository.findById(induccion.getEmpresa().getId());

        if (coordinador.isPresent() && empresa.isPresent()) {
            return induccionRepository.save(induccion);
        } else {
            // Manejar el caso cuando no se encuentran las claves foráneas
            throw new IllegalArgumentException("Coordinador o Empresa no existen.");
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
