package com.example.mspracticante.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class Carta_presentacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "practicante_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Practicante practicante;
    private String cartaArchivo;
    private Integer cartaEstado;
    private String cartaInstitucion;
    private Long cartaRuc;
    private String cartaRepresentante;
    private Integer cartaFecha;
    private String cartaCargo;

}
