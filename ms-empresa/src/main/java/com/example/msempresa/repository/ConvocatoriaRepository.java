package com.example.msempresa.repository;

import com.example.msempresa.entity.Convocatoria;
import com.example.msempresa.entity.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConvocatoriaRepository extends JpaRepository<Convocatoria,Integer> {
}
