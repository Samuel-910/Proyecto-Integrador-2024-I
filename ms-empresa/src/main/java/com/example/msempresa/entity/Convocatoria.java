package com.example.msempresa.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
@Entity
@Data
public class Convocatoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String convocatoriaSalario;
    private String convocatoriaTitulo;
    private String convocatoriaPuesto;
    private String convocatoriaDescripcion;
    private Long convocatoriaVacantes;
    private Integer convocatoriaExperiencia;
    private String convocatoriaIdiomas;
    private LocalDate convocatoriaFechaInicio;
    private LocalDate convocatoriaFechaFin;
    private String convocatoriaEstado;
    private Integer convocatoriaFormaAca;

}
