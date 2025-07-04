package com.nocountry.conversafe.Controllers;

import com.nocountry.conversafe.Models.Dtos.Usuario.UsuarioResponseDTO;
import com.nocountry.conversafe.services.UsuarioService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/usuario")
@SecurityRequirement(name = "bearer-key")
public class UsuarioController {
    private final UsuarioService usuarioService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public UsuarioResponseDTO getUserByEmail(@RequestParam("email") String email){
        return usuarioService.getUsuarioByEmail(email);
    }
}
