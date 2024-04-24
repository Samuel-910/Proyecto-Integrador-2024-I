package com.example.mscoordinador.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "empresa_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Empresa empresa;
    private String convenioArchivo;
    private Integer practicanteId;
}
