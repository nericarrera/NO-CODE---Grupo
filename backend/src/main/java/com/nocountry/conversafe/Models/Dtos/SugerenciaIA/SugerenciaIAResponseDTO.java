package com.nocountry.conversafe.Models.Dtos.SugerenciaIA;

import com.nocountry.conversafe.Models.Entities.Mensaje;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


public record SugerenciaIAResponseDTO(String tipo, String descripcion, String mensajeRelacionado, String sugeridoEn) {
}
