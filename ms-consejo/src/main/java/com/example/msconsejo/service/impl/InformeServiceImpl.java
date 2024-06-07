package com.example.msconsejo.service.impl;

import com.example.msconsejo.entity.Informe;
import com.example.msconsejo.entity.Revision;
import com.example.msconsejo.feign.PracticanteFeign;
import com.example.msconsejo.repository.InformeRepository;
import com.example.msconsejo.repository.RevisionRepository;
import com.example.msconsejo.service.InformeService;
import com.example.msconsejo.service.RevisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class InformeServiceImpl implements InformeService {
    @Autowired
    InformeRepository informeRepository;
    @Autowired
    private PracticanteFeign practicanteFeign;

    @Override
    public List<Informe> listar() {
        List<Informe> informes = informeRepository.findAll();
        informes.forEach(informe -> {
            informe.setPracticanteDto(practicanteFeign.buscarPorId(informe.getPracticanteId()).getBody());
        });
        return informes;

    }

    @Override
    public Informe guardar(Informe informe) {
        ResponseEntity<?> response = practicanteFeign.buscarPorId(informe.getPracticanteId());
        if (response.getStatusCode().is4xxClientError()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Practicante con ID " + informe.getPracticanteId() + " no encontrado.");
        }
        return informeRepository.save(informe);
    }


    @Override
    public Informe buscarPorId(Integer id) {
        Informe informe = informeRepository.findById(id).get();
        informe.setPracticanteDto(practicanteFeign.buscarPorId(informe.getPracticanteId()).getBody());
        return informe;
    }

    @Override
    public Informe actualizar(Informe informe) {
        return informeRepository.save(informe);
    }

    @Override
    public void eliminar(Integer id) {
        informeRepository.deleteById(id);

    }
}
