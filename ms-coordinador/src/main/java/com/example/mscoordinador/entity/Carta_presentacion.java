package com.example.mscoordinador.entity;

import com.example.mscoordinador.dto.PracticanteDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class Carta_presentacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer practicanteId;
    private String cartaArchivo;
    private Integer cartaEstado;
    private String cartaInstitucion;
    private Integer cartaRuc;
    private String cartaRepresentante;
    private Integer cartaFecha;
    private String cartaCargo;
    @Transient
    PracticanteDto practicanteDto;
}
