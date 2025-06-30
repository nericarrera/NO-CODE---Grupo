package com.nocountry.conversafe.Models.Dtos.Usuario;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public record UsuarioRequestDTO(String nombre, String password, String email) {
}
