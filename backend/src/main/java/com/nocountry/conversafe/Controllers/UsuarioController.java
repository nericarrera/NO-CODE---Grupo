package com.nocountry.conversafe.Controllers;

import com.nocountry.conversafe.Models.Dtos.Usuario.UsuarioResponseDTO;
import com.nocountry.conversafe.services.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/usuario")
public class UsuarioController {
    private final UsuarioService usuarioService;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UsuarioResponseDTO getUsario(@PathVariable("id") Long id){
        return usuarioService.getUsuario(id);
    }
}
