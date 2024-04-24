package com.example.mscoordinador.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;


@Data
public class Carta_presentacion {
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "practicante_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Practicante practicante;
    private String cartaArchivo;
    private Integer cartaEstado;
    private String cartaInstitucion;
    private Integer cartaRuc;
    private String cartaRepresentante;
    private Integer cartaFecha;
    private String cartaCargo;

}
