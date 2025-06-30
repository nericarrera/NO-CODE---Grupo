package com.nocountry.conversafe.Models.Dtos.Mensaje;

import com.nocountry.conversafe.Models.Entities.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MensajeResponseDTO {

    private Usuario autor;
    private String contenido;
    private LocalDateTime timestamp;
}
