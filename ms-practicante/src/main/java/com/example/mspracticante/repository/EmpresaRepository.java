package com.example.mspracticante.repository;

import com.example.msempresa.entity.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository  extends JpaRepository<Empresa,Integer> {
}
