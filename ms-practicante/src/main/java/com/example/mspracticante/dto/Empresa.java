package com.example.mspracticante.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class Empresa {
    private Integer id;
    private String empNombre;
    private String empDni;
    private String empTelefono;
    private String empCorreo;
    private String empDireccion;
}
