package com.example.mscoordinador.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class Convocatoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String convocatoriaSalario;
    private String convocatoriaTitulo;
    private String convocatoriaPuesto;
    private String convocatoriaDescripcion;
    private Integer convocatoriaVacantes;
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
