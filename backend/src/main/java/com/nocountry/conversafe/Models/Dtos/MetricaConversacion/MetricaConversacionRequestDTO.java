package com.nocountry.conversafe.Models.Dtos.MetricaConversacion;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public record MetricaConversacionRequestDTO (
        Integer totalMensajes,
        Integer mensajesSinRespuesta,
        Double participacionPromedio,
        String tonoGeneral,
        Integer decisionesDetectadas,
        Integer responsablesAsignados
){

}
