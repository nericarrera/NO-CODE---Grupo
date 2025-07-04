package com.nocountry.conversafe.Models.Mappers;

import com.nocountry.conversafe.Models.Dtos.Chat.ChatRequestDTO;
import com.nocountry.conversafe.Models.Dtos.Chat.ChatResponseDTO;

import com.nocountry.conversafe.Models.Dtos.Mensaje.MensajeResponseDTO;
import com.nocountry.conversafe.Models.Entities.Chat;
import com.nocountry.conversafe.Models.Entities.Mensaje;
import com.nocountry.conversafe.Models.Entities.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface ChatMapper {

    Chat toEntity(ChatRequestDTO chatRequestDTO);

    ChatResponseDTO toDTO(Chat chat);

//    @Named("mapUsuarioListToIdList")
//    default List<Long> mapUsuarioListToIdList(List<Usuario> participantes) {
//        return participantes.stream()
//                .map(Usuario::getId)
//                .collect(Collectors.toList());
//    }


}
