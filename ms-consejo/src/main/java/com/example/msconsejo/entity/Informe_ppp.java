package com.example.msconsejo.entity;

import com.example.msconsejo.dto.PracticanteDto;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class Informe_ppp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // ID único para cada informe.
    @Column(nullable = false)
    private String enlaceDocumento; // Enlace al documento completo.
    @Column(nullable = false)
    private String fechaEnvio; // Fecha de envío del informe.
    @Column(nullable = false)
    private String resumen; // Resumen del informe.
    @Column(nullable = false)
    private String estado; // Estado actual del informe ('Pendiente', 'Revisado').
    @Column(nullable = false)
    private Integer practicanteId; // ID del estudiante que presenta el informe.

    @Transient
    PracticanteDto practicanteDto;
}
