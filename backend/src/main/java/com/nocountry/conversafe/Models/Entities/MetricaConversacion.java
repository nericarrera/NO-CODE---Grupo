package com.nocountry.conversafe.Models.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MetricaConversacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer totalMensajes;
    private Integer mensajesSinRespuesta;
    private Double participacionPromedio; // Ej: 0.65 = 65%
    private String tonoGeneral; // Positivo, Neutro, Negativo
    private Integer decisionesDetectadas;
    private Integer responsablesAsignados;

    private LocalDateTime generadoEn;

    @PrePersist
    protected void onCreate() {
        //se hace esto cuando se crea una nueva entidad.
        this.generadoEn = LocalDateTime.now();
    }
}
