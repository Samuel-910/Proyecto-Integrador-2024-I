package com.example.mspracticante.entity;

import com.example.mspracticante.dto.ConvocatoriaDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Inscripcion_convocatoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String inscripcionEstado;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "practicante_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Practicante practicante;
    private String inscripcionGanador;

    private Integer convocatoriaId;

    @Transient
    ConvocatoriaDto convocatoriaDto;

}
