package com.example.msconsejo.service.impl;

import com.example.msconsejo.entity.ConsejoEP;
import com.example.msconsejo.repository.ConsejoRepository;
import com.example.msconsejo.service.ConsejoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsejoServiceImpl implements ConsejoService {
    @Autowired

    ConsejoRepository consejoRepository;

    @Override
    public List<ConsejoEP> listar() {
        return consejoRepository.findAll();
    }

    @Override
    public ConsejoEP guardar(ConsejoEP consejoEP) {
        return consejoRepository.save(consejoEP);
    }

    @Override
    public Optional<ConsejoEP> buscarPorId(Integer id) {
        return consejoRepository.findById(id);
    }

    @Override
    public ConsejoEP actualizar(ConsejoEP consejoEP) {
        return consejoRepository.save(consejoEP);
    }

    @Override
    public void eliminar(Integer id) {
        consejoRepository.deleteById(id);

    }
}
