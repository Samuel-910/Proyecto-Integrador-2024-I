package com.example.mssupervisor.entity;

import com.example.mssupervisor.dto.PracticanteDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Evaluacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer practicanteId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supervisor_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Supervisor supervisor;
    private String fecha;
    private String comentarios;
    private Integer puntuacion;
    @Transient
    PracticanteDto practicanteDto;
}
