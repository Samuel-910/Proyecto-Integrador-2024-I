package com.example.mspracticante.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class PersoConvo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String documento;
    private String estado;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "practicante_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Practicante practicante;
}
