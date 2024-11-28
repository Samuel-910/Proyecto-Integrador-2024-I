package com.example.mspracticante.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
@Entity
@Data
public class Practicante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String practicanteNombre;
    private String practicanteDni;
    private String practicanteTelefono;
    private String practicanteCorreo;
    private String practicanteDireccion;
    private String practicantePassword;
    private String practicanteSexo;
    private Integer practicanteCiclo;
    private Integer practicanteCodigo;
    private Integer practicanteEdad;
    private String practicanteArea;
    private String practicanteEstado;
    private Integer auth;
}
