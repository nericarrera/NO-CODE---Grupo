package com.nocountry.conversafe.Models.Dtos.Mensaje;


public record MensajeRequestDTO(
        Long autorId,
        Long chatId,
        String contenido) {
}
