package com.example.mspracticante.feign;

import com.example.mspracticante.dto.ConvocatoriaDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-coordinador-service",path = "/convocatoria")
public interface ConvocatoriaFeign {
    @GetMapping("/{id}")
    @CircuitBreaker(name = "convocatoriaListarPorIdCB", fallbackMethod = "fallbackConvocatoriaPorId")
    public ResponseEntity<ConvocatoriaDto> buscarPOrId(@PathVariable(required = true) Integer id);
    default ResponseEntity<ConvocatoriaDto> fallbackConvocatoriaPorId(Integer id, Exception e) {
        return ResponseEntity.ok(new ConvocatoriaDto());
    }
}
