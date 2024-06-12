package com.example.mscoordinador.service.impl;

import com.example.mscoordinador.entity.Convocatoria;
import com.example.mscoordinador.entity.Empresa;
import com.example.mscoordinador.repository.ConvocatoriaRepository;
import com.example.mscoordinador.repository.EmpresaRepository;
import com.example.mscoordinador.service.ConvocatoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@Service
public class ConvocatoriaServiceImpl implements ConvocatoriaService {
    @Autowired
    ConvocatoriaRepository convocatoriaRepository;
    @Autowired
    private EmpresaRepository empresaRepository;
    @Override
    public List<Convocatoria> listar() {
        return convocatoriaRepository.findAll();
    }

    @Override
    public Convocatoria guardar(Convocatoria convocatoria) {
        return convocatoriaRepository.save(convocatoria);
    }

    @Override
    public Convocatoria buscarPorId(Integer id) {
        return convocatoriaRepository.findById(id).orElse(null);
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
