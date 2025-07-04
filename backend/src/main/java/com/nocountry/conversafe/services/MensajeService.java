package com.nocountry.conversafe.services;

import com.nocountry.conversafe.Models.Dtos.Mensaje.MensajeRequestDTO;
import com.nocountry.conversafe.Models.Dtos.Mensaje.MensajeResponseDTO;
import com.nocountry.conversafe.Models.Entities.Chat;
import com.nocountry.conversafe.Models.Entities.Mensaje;
import com.nocountry.conversafe.Models.Entities.Usuario;
import com.nocountry.conversafe.Models.Mappers.MensajeMapper;
import com.nocountry.conversafe.repository.ChatRepository;
import com.nocountry.conversafe.repository.MessageRepository;
import com.nocountry.conversafe.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MensajeService {

    private final MessageRepository messageRepository;
    private final UserRepository userRepository;
    private final ChatRepository chatRepository;
    private final MensajeMapper mensajeMapper;
    private final SimpMessagingTemplate messagingTemplate;

    public MensajeResponseDTO getMensaje(Long id){
        Mensaje mensaje=messageRepository.findById(id)
                .orElseThrow(()->new RuntimeException("no existe este mensaje"));

        return mensajeMapper.toDTO(mensaje);
    }

    public Mensaje enviarMensaje(MensajeRequestDTO mensaje){

        Chat chat=chatRepository.findById(mensaje.chatId())
                .orElseThrow(()->new RuntimeException("error"));

        Usuario user=userRepository.findById(mensaje.autorId())
                .orElseThrow(()->new RuntimeException("error"));

        Mensaje newMensaje=new Mensaje();
        newMensaje.setAutor(user);
        newMensaje.setContenido(mensaje.contenido());
        newMensaje.setChat(chat);

        Mensaje saved= messageRepository.save(newMensaje);
        saved.setChat(chat);

        //publica el mensaje y el front se suscribe y muestra el msg en el chat
        messagingTemplate.convertAndSend("/topic/mensajes/" + chat.getId(), mensajeMapper.toDTO(saved));

        return saved;
    }


}
