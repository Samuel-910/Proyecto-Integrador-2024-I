package com.example.mssupervisor.service.impl;

import com.example.mssupervisor.entity.Supervisor;
import com.example.mssupervisor.repository.SupervisorRepository;
import com.example.mssupervisor.service.SupervisorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupervisorServiceImpl implements SupervisorService {
    @Autowired

    SupervisorRepository supervisorRepository;

    @Override
    public List<Supervisor> listar() {
        return supervisorRepository.findAll();
    }

    @Override
    public Supervisor guardar(Supervisor supervisor) {
        return supervisorRepository.save(supervisor);
    }

    @Override
    public Optional<Supervisor> buscarPorId(Integer id) {
        return supervisorRepository.findById(id);
    }

    @Override
    public Supervisor actualizar(Supervisor supervisor) {
        return supervisorRepository.save(supervisor);
    }

    @Override
    public void eliminar(Integer id) {
        supervisorRepository.deleteById(id);

    }
}
