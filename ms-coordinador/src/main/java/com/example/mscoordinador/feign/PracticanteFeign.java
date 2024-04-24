package com.example.mscoordinador.feign;

import com.example.mscoordinador.dto.Practicante;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-practicante-service",path = "/practicante")
public interface PracticanteFeign {
    @GetMapping("/{id}")
    public ResponseEntity<Practicante> buscarPorId(@PathVariable(required = true) Practicante id);
}
