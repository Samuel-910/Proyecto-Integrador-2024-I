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
    private String Salario;
    private String Titulo;
    private String Puesto;
    private String Descripcion;
    private Integer Vacantes;
    private Integer Experiencia;
    private String Idiomas;
    private String FechaInicio;
    private String FechaFin;
    private String Estado;
    private Integer FormaAca;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "empresa_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Empresa empresa;
}
