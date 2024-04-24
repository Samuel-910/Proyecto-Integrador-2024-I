package com.example.mspracticante.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;


@Data
public class Convocatoria {
    private Integer id;
    private String convocatoriaSalario;
    private String convocatoriaTitulo;
    private String convocatoriaPuesto;
    private String convocatoriaDescripcion;
    private Long convocatoriaVacantes;
    private Integer convocatoriaExperiencia;
    private String convocatoriaIdiomas;
    private String convocatoriaFechaInicio;
    private String convocatoriaFechaFin;
    private String convocatoriaEstado;
    private Integer convocatoriaFormaAca;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "empresa_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Empresa empresa;
}