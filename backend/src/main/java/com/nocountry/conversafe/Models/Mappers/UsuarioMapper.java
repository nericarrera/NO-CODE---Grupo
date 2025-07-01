package com.nocountry.conversafe.Models.Mappers;

import com.nocountry.conversafe.Models.Dtos.Usuario.UsuarioRequestDTO;
import com.nocountry.conversafe.Models.Dtos.Usuario.UsuarioResponseDTO;
import com.nocountry.conversafe.Models.Dtos.Usuario.UsuarioResponseMsgDTO;
import com.nocountry.conversafe.Models.Entities.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    UsuarioResponseDTO toDTO(Usuario usuario);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "equipo", ignore = true)
    @Mapping(target = "chats", ignore = true)
    @Mapping(target = "mensajes", ignore = true)
    Usuario toEntity(UsuarioRequestDTO usuarioRequestDTO);

    UsuarioResponseMsgDTO toMsgDTO(Usuario usuario);

}
