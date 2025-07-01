package com.nocountry.conversafe.Models.Dtos.Chat;


import java.util.List;

public record ChatResponseDTO(String nombre, List<Long> id_participantes) {
}
