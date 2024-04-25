package com.example.mspracticante.dto;

import lombok.Data;


@Data
public class ConvocatoriaDto {
    private Integer id;
    private String convocatoriaSalario;
    private String convocatoriaTitulo;
    private String convocatoriaPuesto;
    private String convocatoriaDescripcion;
    private Long convocatoriaVacantes;
    private Integer convocatoriaExperiencia;
    private String convocatoriaIdiomas;
    private String convocatoriaFechaInicio;
    private String convocatoriaFechaFin;
    private String convocatoriaEstado;
    private Integer convocatoriaFormaAca;
    private EmpresaDto empresa;
}
