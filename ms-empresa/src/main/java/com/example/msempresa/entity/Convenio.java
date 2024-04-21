package com.example.msempresa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import java.time.LocalDate;
@Entity
@Data
public class Convenio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String convenioTipoConvenio;
    private LocalDate convenioFechaInicio;
    private LocalDate convenioFechaFin;
    private String convenioEstado;
    private Long empId;
    private Long practicanteId;
    private String convenioArchivo;
}
