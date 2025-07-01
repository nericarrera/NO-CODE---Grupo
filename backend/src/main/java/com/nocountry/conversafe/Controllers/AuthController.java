package com.nocountry.conversafe.Controllers;

import com.nocountry.conversafe.Models.Dtos.Jwt.JwtResponseDTO;
import com.nocountry.conversafe.Models.Dtos.Usuario.UsuarioLoginDTO;
import com.nocountry.conversafe.Models.Dtos.Usuario.UsuarioRequestDTO;
import com.nocountry.conversafe.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public JwtResponseDTO AuthenticateUser(@RequestBody UsuarioLoginDTO usuarioLoginDTO){
       return authService.authenticate(usuarioLoginDTO);
    }
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> registerUser(@RequestBody UsuarioRequestDTO usuarioRequestDTO) {
        authService.register(usuarioRequestDTO);
        return ResponseEntity.ok("Usuario registrado correctamente.");
    }
}
