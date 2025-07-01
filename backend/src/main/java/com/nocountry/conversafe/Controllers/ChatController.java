package com.nocountry.conversafe.Controllers;

import com.nocountry.conversafe.Models.Dtos.Chat.ChatRequestDTO;
import com.nocountry.conversafe.Models.Dtos.Chat.ChatResponseDTO;
import com.nocountry.conversafe.services.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chat")
@RequiredArgsConstructor
public class ChatController {

    private final ChatService chatService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ChatResponseDTO saveChat(@RequestBody ChatRequestDTO chatRequestDTO){
        return chatService.saveChat(chatRequestDTO);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ChatResponseDTO getChat(@PathVariable("id") Long id){
        return chatService.getChat(id);
    }

    @GetMapping("/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public List<ChatResponseDTO> getChatsByUser(@PathVariable("userId")Long userId){
        return chatService.getChatsByUser(userId);
    }
}
