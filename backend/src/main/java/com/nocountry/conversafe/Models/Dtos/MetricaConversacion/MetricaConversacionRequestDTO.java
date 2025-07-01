package com.nocountry.conversafe.Models.Dtos.MetricaConversacion;

public record MetricaConversacionRequestDTO (
        Integer totalMensajes,
        Integer mensajesSinRespuesta,
        Double participacionPromedio,
        String tonoGeneral,
        Integer decisionesDetectadas,
        Integer responsablesAsignados
){

}
