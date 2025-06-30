package com.nocountry.conversafe.Models.Dtos.SugerenciaIA;

import com.nocountry.conversafe.Models.Entities.Mensaje;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SugerenciaIARequestDTO {

    private String tipo;
    private String descripcion;
    private Mensaje mensajeRelacionado;
}
