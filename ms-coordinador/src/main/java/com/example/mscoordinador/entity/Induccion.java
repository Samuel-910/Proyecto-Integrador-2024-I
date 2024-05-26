package com.example.mscoordinador.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Induccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private LocalDate fechaInicio;

    @Column(nullable = false)
    private LocalDate fechaFin;

    @Column(nullable = false)
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "coordinador_id", nullable = false)
    private Coordinador coordinador;

    @ManyToOne
    @JoinColumn(name = "empresa_id", nullable = false)
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
}
