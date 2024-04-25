package com.example.mspracticante.feign;

import com.example.mspracticante.dto.ConvocatoriaDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-coordinador-service",path = "/convocatoria")
public interface ConvocatoriaFeign {
    @GetMapping("/{id}")
    public ResponseEntity<ConvocatoriaDto> buscarPOrId(@PathVariable(required = true) Integer id);
}
