package com.nocountry.conversafe.Models.Dtos.MetricaConversacion;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


public record MetricaConversacionResponseDTO(
        Integer totalMensajes,
    Integer mensajesSinRespuesta,
    Double participacionPromedio,
    String tonoGeneral,
    Integer decisionesDetectadas,
    Integer responsablesAsignados,
    String generadoEn) {
}
