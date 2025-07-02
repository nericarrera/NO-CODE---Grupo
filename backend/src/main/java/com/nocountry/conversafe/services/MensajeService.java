package com.nocountry.conversafe.services;

import com.nocountry.conversafe.Models.Dtos.Mensaje.MensajeParaIA;
import com.nocountry.conversafe.Models.Dtos.Mensaje.MensajeRequestDTO;
import com.nocountry.conversafe.Models.Dtos.Mensaje.MensajeResponseDTO;
import com.nocountry.conversafe.Models.Dtos.Usuario.UsuarioResponseMsgDTO;
import com.nocountry.conversafe.Models.Entities.Chat;
import com.nocountry.conversafe.Models.Entities.Mensaje;
import com.nocountry.conversafe.Models.Entities.Usuario;
import com.nocountry.conversafe.Models.Mappers.MensajeMapper;
import com.nocountry.conversafe.TESTEO.GeminiAI;
import com.nocountry.conversafe.TESTEO.MensajeBufferPorChat;
import com.nocountry.conversafe.repository.ChatRepository;
import com.nocountry.conversafe.repository.MessageRepository;
import com.nocountry.conversafe.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MensajeService {

    private final MessageRepository messageRepository;
    private final UserRepository userRepository;
    private final ChatRepository chatRepository;
    private final MensajeMapper mensajeMapper;
    private final MensajeBufferPorChat mensajeBufferPorChat;
    private final GeminiAI geminiAI;

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

        procesarMensajeParaAnalisis(chat.getId(),newMensaje);

        return mensajeMapper.toDTO(saved);
    }

    //si un chat llega a 20 mensajes enviados sin analizar se envia la consulta a la ia con la lista de msg.
    private void procesarMensajeParaAnalisis(Long chatId,Mensaje mensaje){
        mensajeBufferPorChat.agregar(chatId,mensajeMapper.toIaDTO(mensaje));

        if(mensajeBufferPorChat.estaListo(chatId)){
            List<MensajeParaIA>mensajes=mensajeBufferPorChat.vaciar(chatId);
            System.out.println("se mando el evento!");
            geminiAI.enviarAnalisis(chatId,mensajes);
        }

    }

}
