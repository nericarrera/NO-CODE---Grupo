package com.nocountry.conversafe.services;

import com.nocountry.conversafe.Models.Dtos.Mensaje.MensajeRequestDTO;
import com.nocountry.conversafe.Models.Dtos.Mensaje.MensajeResponseDTO;
import com.nocountry.conversafe.Models.Dtos.Usuario.UsuarioResponseMsgDTO;
import com.nocountry.conversafe.Models.Entities.Chat;
import com.nocountry.conversafe.Models.Entities.Mensaje;
import com.nocountry.conversafe.Models.Entities.Usuario;
import com.nocountry.conversafe.Models.Mappers.MensajeMapper;
import com.nocountry.conversafe.repository.ChatRepository;
import com.nocountry.conversafe.repository.MessageRepository;
import com.nocountry.conversafe.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MensajeService {

    private final MessageRepository messageRepository;
    private final UserRepository userRepository;
    private final ChatRepository chatRepository;
    private final MensajeMapper mensajeMapper;

    public MensajeResponseDTO getMensaje(Long id){
        Mensaje mensaje=messageRepository.findById(id)
                .orElseThrow(()->new RuntimeException("no existe este mensaje"));

        return mensajeMapper.toDTO(mensaje);
    }

    public MensajeResponseDTO enviarMensaje(MensajeRequestDTO mensaje){

        Chat chat=chatRepository.findById(mensaje.chatId())
                .orElseThrow(()->new RuntimeException("error"));

        Usuario user=userRepository.findById(mensaje.autorId())
                .orElseThrow(()->new RuntimeException("error"));

        Mensaje newMensaje=new Mensaje();
        newMensaje.setAutor(user);
        newMensaje.setContenido(mensaje.contenido());
        newMensaje.setChat(chat);

        Mensaje saved= messageRepository.save(newMensaje);

        return mensajeMapper.toDTO(saved);
    }

}
