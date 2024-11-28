package com.example.mspracticante.service.impl;

import com.example.mspracticante.entity.Evidencias;
import com.example.mspracticante.repository.EvidenciaRepository;
import com.example.mspracticante.service.EvidenciasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EvidenciasServiceImpl implements EvidenciasService {

    @Autowired
    private EvidenciaRepository evidenciaRepository;

    @Override
    public List<Evidencias> listar() {
        return evidenciaRepository.findAll();
    }

    @Override
    public Evidencias guardar(Evidencias evidencia) {
        return evidenciaRepository.save(evidencia);
    }

    @Override
    public Optional<Evidencias> buscarPorId(Integer id) {
        return evidenciaRepository.findById(id);
    }

    @Override
    public Evidencias actualizar(Integer id, Evidencias evidencia) {
        // Verificar si la evidencia existe
        if (!evidenciaRepository.existsById(id)) {
            throw new RuntimeException("Evidencia no encontrada con id: " + id);
        }
        evidencia.setId(id);
        return evidenciaRepository.save(evidencia);
    }

    @Override
    public void eliminar(Integer id) {
        if (!evidenciaRepository.existsById(id)) {
            throw new RuntimeException("Evidencia no encontrada con id: " + id);
        }
        evidenciaRepository.deleteById(id);
    }
}
