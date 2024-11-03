package com.example.mspracticante.dto;

import lombok.Data;


@Data
public class ConvocatoriaDto {
    private Integer id;
    private String Salario;
    private String Titulo;
    private String Puesto;
    private String Descripcion;
    private Long Vacantes;
    private Integer Experiencia;
    private String Idiomas;
    private String FechaInicio;
    private String FechaFin;
    private String Estado;
    private Integer FormaAca;
    private EmpresaDto empresa;
}
