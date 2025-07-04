package com.nocountry.conversafe.Models.Mappers;

import com.nocountry.conversafe.Models.Dtos.Mensaje.MensajeResponseDTO;
import com.nocountry.conversafe.Models.Entities.Mensaje;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",uses = {UsuarioMapper.class})
public interface MensajeMapper {

    @Mapping(source = "chat.id", target = "chatId")
    @Mapping(source = "timestamp", target = "timestamp", dateFormat = "yyyy-MM-dd'T'HH:mm:ss")
    @Mapping(source = "autor", target = "autor") // usa UsuarioMapper.toMsgDTO()
    MensajeResponseDTO toDTO(Mensaje mensaje);

}
