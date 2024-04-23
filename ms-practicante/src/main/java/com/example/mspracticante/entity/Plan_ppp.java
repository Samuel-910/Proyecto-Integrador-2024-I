package com.example.mspracticante.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Plan_ppp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String planInicio;
    private String planFin;
    private Integer planHoras;
    private Integer planModalidad;
    private Integer planTurno;
    private String planArchivo;
    private String planSuperNombre;
    private String planSuperCorreo;
    private Integer planSuperNumero;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "practicante_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Practicante practicante;

}
