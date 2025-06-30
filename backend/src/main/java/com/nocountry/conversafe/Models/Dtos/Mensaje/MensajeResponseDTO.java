package com.nocountry.conversafe.Models.Dtos.Mensaje;

import com.nocountry.conversafe.Models.Entities.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

public record MensajeResponseDTO(
        Usuario autor,
        String contenido,
        String timestamp
) {


}
