package com.nocountry.conversafe.Models.Dtos.Chat;


import com.nocountry.conversafe.Models.Dtos.Mensaje.MensajeResponseDTO;

import java.util.List;

public record ChatResponseDTO(Long id, String nombre, List<MensajeResponseDTO> mensajes) {
}
