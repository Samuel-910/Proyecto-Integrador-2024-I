package com.example.mscoordinador.dto;

import lombok.Data;

@Data
public class Inscripcion_convocatoria {
    private Integer id;
    private String inscripcionEstado;
    private Practicante practicante;
    private String inscripcionGanador;
    private String convocatoriaId;

}
