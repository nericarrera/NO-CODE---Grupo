package com.nocountry.conversafe.services;

import com.nocountry.conversafe.Models.Dtos.Chat.ChatRequestDTO;
import com.nocountry.conversafe.Models.Dtos.Chat.ChatResponseDTO;
import com.nocountry.conversafe.Models.Entities.Chat;
import com.nocountry.conversafe.Models.Entities.Usuario;
import com.nocountry.conversafe.Models.Mappers.ChatMapper;
import com.nocountry.conversafe.repository.ChatRepository;
import com.nocountry.conversafe.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatService {

    private final ChatRepository chatRepository;
    private final UserRepository userRepository;
    private final ChatMapper chatMapper;

    public ChatResponseDTO getChat(Long id){
        Chat chat=chatRepository.findById(id)
                .orElseThrow(()->new RuntimeException("no existe este chat"));
        return chatMapper.toDTO(chat);
    }

    public List<ChatResponseDTO>getChatsByUser(Long userId){
        Usuario user=userRepository.findById(userId)
                .orElseThrow(()->new RuntimeException("no existe este user"));

        List<Chat>chats=chatRepository.findAllByParticipantesContains(user);

        return chats.stream()
                .map(chatMapper::toDTO)
                .toList();
    }

    public ChatResponseDTO saveChat(ChatRequestDTO chatRequestDTO){
        Chat chat=new Chat();

        chat.setNombre(chatRequestDTO.nombre());
        chatRepository.save(chat);

        return chatMapper.toDTO(chat);
    }

    public void deleteChat(Long id){
        chatRepository.deleteById(id);
    }
}
