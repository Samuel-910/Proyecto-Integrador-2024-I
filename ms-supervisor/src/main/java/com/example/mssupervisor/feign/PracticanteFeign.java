package com.example.mssupervisor.feign;

import com.example.mssupervisor.dto.PracticanteDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-practicante-service",path = "/practicante")
public interface PracticanteFeign {
    @GetMapping("/{id}")
    @CircuitBreaker(name = "practicanteListarPorIdCB", fallbackMethod = "fallbackPracticantePorID")
    public ResponseEntity<PracticanteDto> buscarPorId(@PathVariable(required = true) Integer id);
    default ResponseEntity<PracticanteDto> fallbackPracticantePorID(Integer id, Exception e) {
        return ResponseEntity.ok(new PracticanteDto());
    }
}
