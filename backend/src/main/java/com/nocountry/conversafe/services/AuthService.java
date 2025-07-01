package com.nocountry.conversafe.services;

import com.nocountry.conversafe.Config.Security.Jwt.JwtUtils;
import com.nocountry.conversafe.Models.Dtos.Jwt.JwtResponseDTO;
import com.nocountry.conversafe.Models.Dtos.Usuario.UsuarioLoginDTO;
import com.nocountry.conversafe.Models.Dtos.Usuario.UsuarioRequestDTO;
import com.nocountry.conversafe.Models.Entities.Usuario;
import com.nocountry.conversafe.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public JwtResponseDTO authenticate(UsuarioLoginDTO usuarioLoginDTO) {
        Authentication authentication=authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        usuarioLoginDTO.email(),
                        usuarioLoginDTO.password()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return new JwtResponseDTO(jwtUtils.generateToken(usuarioLoginDTO.email()));
    }

    public void register(UsuarioRequestDTO usuarioRequestDTO) {
        if (userRepository.existsByEmail(usuarioRequestDTO.email())) {
            throw new RuntimeException("El nombre de usuario ya existe.");
        }

        Usuario newUser = new Usuario();
        newUser.setNombre(usuarioRequestDTO.nombre());
        newUser.setEmail(usuarioRequestDTO.email());
        newUser.setPassword(passwordEncoder.encode(usuarioRequestDTO.password()));

        userRepository.save(newUser);
    }
}
