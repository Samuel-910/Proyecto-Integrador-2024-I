package com.example.mscoordinador.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class Practicante {
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
}
