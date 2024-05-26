package com.example.msconsejo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Revision {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // ID único para cada Revicion.

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "informe_ppp_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Informe_ppp informe_ppp; // Relación con la tabla Informes como clave foránea.

    @Column(nullable = false)
    private String decision; // Enum ('Aprobado', 'Rechazado').

    @Column(nullable = false)
    private String fechaDecision; // Fecha en la que se tomó la decisión.

    @Column(nullable = false)
    private String comentarios;// Comentarios adicionales sobre la decisión.

}
