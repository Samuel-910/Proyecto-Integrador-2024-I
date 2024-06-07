package com.example.msconsejo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Revision {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // ID único para cada revisión. Se autoincrementa automáticamente.

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "informe_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Informe informe; // Relación con la tabla 'Informes' como clave foránea.

    @Column(nullable = false)
    private String decision; // Valor enum ('Aprobado', 'Rechazado'). Indica la decisión de la revisión.

    @Column(nullable = false)
    private String fechaDecision; // Fecha en la que se tomó la decisión. Debe ser proporcionada.

    @Column(nullable = false)
    private String comentarios; // Comentarios adicionales sobre la decisión. Campo obligatorio.
}
