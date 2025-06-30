package com.nocountry.conversafe.Models.Dtos.Mensaje;

import com.nocountry.conversafe.Models.Entities.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MensajeRequestDTO {

    private Usuario autor;
    private String contenido;
}
