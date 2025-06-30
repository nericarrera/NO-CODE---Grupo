package com.nocountry.conversafe.Models.Dtos.SugerenciaIA;

import com.nocountry.conversafe.Models.Dtos.Mensaje.MensajeResponseDTO;
import com.nocountry.conversafe.Models.Entities.Mensaje;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public record SugerenciaIARequestDTO(String tipo, String descripcion, MensajeResponseDTO mensaje) {
}
