package com.example.mspracticante.service.impl;

import com.example.mspracticante.entity.Plan_ppp;
import com.example.mspracticante.repository.Plan_pppRepository;
import com.example.mspracticante.service.Plan_pppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class Plan_pppServiceImpl implements Plan_pppService {
    @Autowired
    Plan_pppRepository plan_pppRepository;
    @Override
    public List<Plan_ppp> listar() {
        return plan_pppRepository.findAll();
    }

    @Override
    public Plan_ppp guardar(Plan_ppp plan_ppp) {
        if (plan_ppp.getPracticante() == null || !plan_pppRepository.existsById(plan_ppp.getPracticante().getId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Practicante   con ID " + plan_ppp.getPracticante().getId() + " no encontrada.");
        }
        return plan_pppRepository.save(plan_ppp);
    }

    @Override
    public Optional<Plan_ppp> buscarPorId(Integer id) {
        return plan_pppRepository.findById(id);
    }

    @Override
    public Plan_ppp actualizar(Plan_ppp plan_ppp) {
        return plan_pppRepository.save(plan_ppp);
    }

    @Override
    public void eliminar(Integer id) {
        plan_pppRepository.deleteById(id);

    }
}
