package com.nocountry.conversafe.Models.Dtos.MetricaConversacion;


public record MetricaConversacionResponseDTO(
        Integer totalMensajes,
    Integer mensajesSinRespuesta,
    Double participacionPromedio,
    String tonoGeneral,
    Integer decisionesDetectadas,
    Integer responsablesAsignados,
    String generadoEn) {
}
