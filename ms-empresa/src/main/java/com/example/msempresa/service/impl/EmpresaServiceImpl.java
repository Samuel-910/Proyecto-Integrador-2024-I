package com.example.msempresa.service.impl;

import com.example.msempresa.entity.Empresa;
import com.example.msempresa.repository.EmpresaRepository;
import com.example.msempresa.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaServiceImpl implements EmpresaService {
    @Autowired
    EmpresaRepository empresaRepository;
    @Override
    public List<Empresa> listar() {
        return empresaRepository.findAll();
    }

    @Override
    public Empresa guardar(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    @Override
    public Optional<Empresa> buscarPorId(Integer id) {
        return empresaRepository.findById(id);
    }

    @Override
    public Empresa actualizar(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    @Override
    public void eliminar(Integer id) {
        empresaRepository.deleteById(id);

    }
}
