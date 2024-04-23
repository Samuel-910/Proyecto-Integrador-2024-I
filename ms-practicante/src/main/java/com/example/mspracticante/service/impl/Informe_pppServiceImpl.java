package com.example.mspracticante.service.impl;

import com.example.mspracticante.entity.Informe_ppp;
import com.example.mspracticante.repository.Informe_pppRepository;
import com.example.mspracticante.service.Informe_pppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Informe_pppServiceImpl implements Informe_pppService {
    @Autowired
    Informe_pppRepository informe_pppRepository;

    @Override
    public List<Informe_ppp> listar() {
        return informe_pppRepository.findAll();
    }

    @Override
    public Informe_ppp guardar(Informe_ppp informe_ppp) {
        return informe_pppRepository.save(informe_ppp);
    }

    @Override
    public Optional<Informe_ppp> buscarPorId(Integer id) {
        return informe_pppRepository.findById(id);
    }

    @Override
    public Informe_ppp actualizar(Informe_ppp informe_ppp) {
        return informe_pppRepository.save(informe_ppp);
    }

    @Override
    public void eliminar(Integer id) {
        informe_pppRepository.deleteById(id);

    }
}
