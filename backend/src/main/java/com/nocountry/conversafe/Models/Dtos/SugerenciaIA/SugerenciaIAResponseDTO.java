package com.nocountry.conversafe.Models.Dtos.SugerenciaIA;

import com.nocountry.conversafe.Models.Entities.Mensaje;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SugerenciaIAResponseDTO {

    private String tipo;
    private String descripcion;
    private Mensaje mensajeRelacionado;
    private LocalDateTime sugeridoEn;
}
