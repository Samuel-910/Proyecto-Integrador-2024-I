package com.example.msconsejo.service.impl;

import com.example.msconsejo.entity.Informe_ppp;
import com.example.msconsejo.feign.PracticanteFeign;
import com.example.msconsejo.repository.Informe_pppRepository;
import com.example.msconsejo.service.Informe_pppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class Informe_pppServiceImpl implements Informe_pppService {
    @Autowired
    Informe_pppRepository informe_pppRepository;

    @Autowired
    private PracticanteFeign practicanteFeign;

    @Override
    public List<Informe_ppp> listar() {

        List<Informe_ppp> informe_ppps = informe_pppRepository.findAll();

        informe_ppps.forEach(informe_ppp -> {
            informe_ppp.setPracticanteDto(practicanteFeign.buscarPorId(informe_ppp.getPracticanteId()).getBody());
        });

        return informe_ppps;
    }

    @Override
    public Informe_ppp guardar(Informe_ppp informe_ppp) {
        ResponseEntity<?> response = practicanteFeign.buscarPorId(informe_ppp.getPracticanteId());
        if (response.getStatusCode().is4xxClientError()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Practicante con ID " + informe_ppp.getPracticanteId() + " no encontrado.");
        }
        return informe_pppRepository.save(informe_ppp);
    }

    @Override
    public Informe_ppp buscarPorId(Integer id) {
        Informe_ppp informe_ppp = informe_pppRepository.findById(id).get();
        informe_ppp.setPracticanteDto(practicanteFeign.buscarPorId(informe_ppp.getPracticanteId()).getBody());
        return informe_ppp;
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
