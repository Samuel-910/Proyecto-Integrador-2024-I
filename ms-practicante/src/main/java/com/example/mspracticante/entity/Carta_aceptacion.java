package com.example.mspracticante.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Carta_aceptacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "practicante_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Practicante practicante;
    private String acepArchivo;
    private String acepDireccion;
    private String acepUbigeo;
    private String acepCoordenadas;
    private String acepEstado;

}
