package com.example.mscoordinador.repository;

import com.example.mscoordinador.entity.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository  extends JpaRepository<Empresa,Integer> {
}
