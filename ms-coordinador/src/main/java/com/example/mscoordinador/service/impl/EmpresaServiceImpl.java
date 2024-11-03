package com.example.mscoordinador.service.impl;

import com.example.mscoordinador.repository.EmpresaRepository;
import com.example.mscoordinador.service.EmpresaService;
import com.example.mscoordinador.entity.Empresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public Empresa buscarPorId(Integer id) {
        return empresaRepository.findById(id).orElse(null);
    }

    @Override
    public Empresa actualizar(Integer id,Empresa empresa) {
        Empresa empresaFromDb = buscarPorId(id);
        empresaFromDb.setDireccion(empresa.getDireccion());
        empresaFromDb.setEmail(empresa.getEmail());
        empresaFromDb.setNombre(empresa.getNombre());
        empresaFromDb.setTelefono(empresa.getTelefono());
        return empresaRepository.save(empresaFromDb);
    }

    @Override
    public void eliminar(Integer id) {
        empresaRepository.deleteById(id);

    }
}
