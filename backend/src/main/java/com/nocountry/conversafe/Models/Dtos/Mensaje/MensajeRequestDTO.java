package com.nocountry.conversafe.Models.Dtos.Mensaje;

import com.nocountry.conversafe.Models.Entities.Usuario;


public record MensajeRequestDTO(
        Usuario autor,
        String contenido) {
}
