package com.example.mspracticante.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Evidencias {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDate inicio;
    private LocalDate fin;
    private int horas;
    private String descripcion;
    private String archivo;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "practicante_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Practicante practicante;
    private Integer inscripcionId;
}
