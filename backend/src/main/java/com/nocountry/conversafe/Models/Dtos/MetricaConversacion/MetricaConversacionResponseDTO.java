package com.nocountry.conversafe.Models.Dtos.MetricaConversacion;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MetricaConversacionResponseDTO {

    private Integer totalMensajes;
    private Integer mensajesSinRespuesta;
    private Double participacionPromedio; // Ej: 0.65 = 65%
    private String tonoGeneral; // Positivo, Neutro, Negativo
    private Integer decisionesDetectadas;
    private Integer responsablesAsignados;
    private LocalDateTime generadoEn;
}
