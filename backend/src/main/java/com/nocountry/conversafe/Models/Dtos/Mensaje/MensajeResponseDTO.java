package com.nocountry.conversafe.Models.Dtos.Mensaje;

import com.nocountry.conversafe.Models.Dtos.Usuario.UsuarioResponseMsgDTO;

public record MensajeResponseDTO(
        UsuarioResponseMsgDTO autor,
        Long chatId,
        String contenido,
        String timestamp
) {
}
