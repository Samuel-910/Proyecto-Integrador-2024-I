package com.example.mspracticante.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
@Data
public class Convenio {
    private Integer id;
    private String convenioTipoConvenio;
    private LocalDate convenioFechaInicio;
    private LocalDate convenioFechaFin;
    private String convenioEstado;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "empresa_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Empresa empresa;
    private String convenioArchivo;
    private Integer practicanteId;
}
