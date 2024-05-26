package com.example.mscoordinador.service.impl;

import com.example.mscoordinador.entity.Carta_presentacion;
import com.example.mscoordinador.feign.PracticanteFeign;
import com.example.mscoordinador.repository.Carta_presentacionRepository;
import com.example.mscoordinador.service.Carta_presentacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@Service
public class Carta_presentacionServiceImpl implements Carta_presentacionService {
    @Autowired
    Carta_presentacionRepository carta_presentacionRepository;
    @Autowired
    private PracticanteFeign practicanteFeign;
    @Override
    public List<Carta_presentacion> listar() {
        List<Carta_presentacion> cartaPresentacions = carta_presentacionRepository.findAll();

        cartaPresentacions.forEach(carta_presentacion -> {
            carta_presentacion.setPracticanteDto(practicanteFeign.buscarPorId(carta_presentacion.getPracticanteId()).getBody());
        });

        return cartaPresentacions;
    }

    @Override
    public Carta_presentacion guardar(Carta_presentacion carta_presentacion) {
        ResponseEntity<?> response = practicanteFeign.buscarPorId(carta_presentacion.getPracticanteId());
        if (response.getStatusCode().is4xxClientError()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Practicante con ID " + carta_presentacion.getPracticanteId() + " no encontrado.");
        }
        return carta_presentacionRepository.save(carta_presentacion);
    }

    @Override
    public Carta_presentacion buscarPorId(Integer id) {
        Carta_presentacion carta_presentacion = carta_presentacionRepository.findById(id).get();
        carta_presentacion.setPracticanteDto(practicanteFeign.buscarPorId(carta_presentacion.getPracticanteId()).getBody());
        return carta_presentacion;
    }

    @Override
    public Carta_presentacion actualizar(Carta_presentacion carta_presentacion) {
        return carta_presentacionRepository.save(carta_presentacion);
    }

    @Override
    public void eliminar(Integer id) {
        carta_presentacionRepository.deleteById(id);

    }
}
