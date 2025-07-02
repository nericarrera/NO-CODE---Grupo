package com.nocountry.conversafe.Controllers;

import com.nocountry.conversafe.Models.Dtos.Mensaje.MensajeRequestDTO;
import com.nocountry.conversafe.Models.Dtos.Mensaje.MensajeResponseDTO;
import com.nocountry.conversafe.services.MensajeService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/msg")
@SecurityRequirement(name = "bearer-key")
public class MensajeController {

    private final MensajeService mensajeService;
    private final SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/mensaje")
    public void enviarMensaje(MensajeRequestDTO mensaje) {
        MensajeResponseDTO response=mensajeService.enviarMensaje(mensaje);
        simpMessagingTemplate.convertAndSend("/topic/mensajes/" + response.chatId(), response);
    }
}
