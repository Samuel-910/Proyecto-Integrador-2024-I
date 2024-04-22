package com.example.msempresa.repository;

import com.example.msempresa.entity.Convenio;
import com.example.msempresa.entity.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConvenioRepository extends JpaRepository<Convenio,Integer> {
}
