package com.example.msconsejo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class ConsejoEP {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer edad;
    private String nombre;
    private String apellido;
    private String correoElectronico;
    private String area;
    private String fechaInicio;
    private String estado;
}
