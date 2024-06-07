package com.example.mscoordinador.service.impl;

import com.example.mscoordinador.entity.Convenio;
import com.example.mscoordinador.feign.PracticanteFeign;
import com.example.mscoordinador.repository.ConvenioRepository;
import com.example.mscoordinador.repository.EmpresaRepository;
import com.example.mscoordinador.service.ConvenioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ConvenioServiceImpl implements ConvenioService {
    @Autowired
    ConvenioRepository convenioRepository;

    @Autowired
    private PracticanteFeign practicanteFeign;

    @Override
    public List<Convenio> listar() {

        List<Convenio> convenios = convenioRepository.findAll();

        convenios.forEach(convenio -> {
            convenio.setPracticanteDto(practicanteFeign.buscarPorId(convenio.getPracticanteId()).getBody());
        });

        return convenios;
    }

    @Override
    public Convenio guardar(Convenio convenio) {
        if (convenio.getEmpresa() == null || !convenioRepository.existsById(convenio.getEmpresa().getId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Empresa   con ID " + convenio.getEmpresa().getId() + " no encontrada.");
        }
        ResponseEntity<?> response = practicanteFeign.buscarPorId(convenio.getPracticanteId());
        if (response.getStatusCode().is4xxClientError()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Practicante con ID " + convenio.getPracticanteId() + " no encontrado.");
        }
        return convenioRepository.save(convenio);
    }

    @Override
    public Convenio buscarPorId(Integer id) {

        Convenio convenio = convenioRepository.findById(id).get();
        convenio.setPracticanteDto(practicanteFeign.buscarPorId(convenio.getPracticanteId()).getBody());
        return convenio;
    }

    @Override
    public Convenio actualizar(Convenio convenio) {
        return convenioRepository.save(convenio);
    }

    @Override
    public void eliminar(Integer id) {
        convenioRepository.deleteById(id);

    }
}
