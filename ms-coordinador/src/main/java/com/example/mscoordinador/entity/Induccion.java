package com.example.mscoordinador.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Induccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String fechaInicio;
    @Column(nullable = false)
    private String fechaFin;
    @Column(nullable = false)
    private String descripcion;
    @ManyToOne
    @JoinColumn(name = "coordinador_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Coordinador coordinador;
    @ManyToOne
    @JoinColumn(name = "empresa_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Empresa empresa;
    @Column(nullable = false)
    private String lugar;
    @Column(nullable = false)
    private String objetivos;
    @Column(nullable = false)
    private String metodologia;
    @Column(nullable = false)
    private String recursosNecesarios;
    @Column(nullable = false)
    private String resultadosEsperados;
    private String observaciones;
    private String estado;
}
