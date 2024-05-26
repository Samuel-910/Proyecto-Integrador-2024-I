package com.example.msconsejo.service.impl;

import com.example.msconsejo.entity.Revision;
import com.example.msconsejo.repository.RevisionRepository;
import com.example.msconsejo.service.RevisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class RevisionServiceImpl implements RevisionService {
    @Autowired
    RevisionRepository revisionRepository;

    @Override
    public List<Revision> listar() {
        return revisionRepository.findAll();
    }

    @Override
    public Revision guardar(Revision revision) {
        if (revision.getInforme() == null || !revisionRepository.existsById(revision.getInforme().getId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Empresa con ID " + revision.getInforme().getId() + " no encontrada.");
        }

        return revisionRepository.save(revision);
    }


    @Override
    public Optional<Revision> buscarPorId(Integer id) {
        return revisionRepository.findById(id);
    }

    @Override
    public Revision actualizar(Revision revision) {
        return revisionRepository.save(revision);
    }

    @Override
    public void eliminar(Integer id) {
        revisionRepository.deleteById(id);

    }
}
