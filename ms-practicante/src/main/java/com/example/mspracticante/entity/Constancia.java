package com.example.mspracticante.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
@Entity
@Data
public class Constancia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String constanciaArchivo;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "practicante_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Practicante practicante;
    private String constanciaEstado;

}
