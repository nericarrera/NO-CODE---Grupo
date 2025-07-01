package com.nocountry.conversafe.Models.Dtos.Mensaje;

import com.nocountry.conversafe.Models.Dtos.Usuario.UsuarioResponseDTO;

public record MensajeResponseDTO(
        UsuarioResponseDTO autor,
        String contenido,
        String timestamp
) {


}
