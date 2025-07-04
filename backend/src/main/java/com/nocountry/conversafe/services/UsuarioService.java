package com.nocountry.conversafe.services;

import com.nocountry.conversafe.Models.Dtos.Usuario.UsuarioResponseDTO;
import com.nocountry.conversafe.Models.Entities.Usuario;
import com.nocountry.conversafe.Models.Mappers.UsuarioMapper;
import com.nocountry.conversafe.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UserRepository userRepository;
    private final UsuarioMapper usuarioMapper;

    public UsuarioResponseDTO getUsuarioByEmail(String email){
        Usuario usuario=userRepository.findByEmail(email)
                .orElseThrow(()->new RuntimeException("no existe este user"));
        return usuarioMapper.toDTO(usuario);
    }


}
