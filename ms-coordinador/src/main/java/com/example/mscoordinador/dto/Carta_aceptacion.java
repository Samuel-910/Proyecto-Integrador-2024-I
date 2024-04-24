package com.example.mscoordinador.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

@Data
public class Carta_aceptacion {
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
