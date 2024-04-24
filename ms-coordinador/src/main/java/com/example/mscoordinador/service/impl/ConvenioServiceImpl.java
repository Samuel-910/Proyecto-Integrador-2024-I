package com.example.mscoordinador.service.impl;

import com.example.mscoordinador.entity.Convenio;
import com.example.mscoordinador.repository.ConvenioRepository;
import com.example.mscoordinador.service.ConvenioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConvenioServiceImpl implements ConvenioService {
    @Autowired

    ConvenioRepository convenioRepository;

    @Override
    public List<Convenio> listar() {
        return convenioRepository.findAll();
    }

    @Override
    public Convenio guardar(Convenio convenio) {
        return convenioRepository.save(convenio);
    }

    @Override
    public Optional<Convenio> buscarPorId(Integer id) {
        return convenioRepository.findById(id);
    }

    @Override
    public Convenio actualizar(Convenio convenio) {
        return convenioRepository.save(convenio);
    }

    @Override
    public void eliminar(Integer id) {
        convenioRepository.deleteById(id);

    }
}
