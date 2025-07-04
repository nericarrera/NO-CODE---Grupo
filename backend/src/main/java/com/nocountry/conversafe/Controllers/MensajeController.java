package com.nocountry.conversafe.Controllers;

import com.nocountry.conversafe.Models.Dtos.Chat.ChatResponseDTO;
import com.nocountry.conversafe.Models.Dtos.Mensaje.MensajeRequestDTO;
import com.nocountry.conversafe.services.IAService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping()
@SecurityRequirement(name = "bearer-key")
@CrossOrigin(origins = "http://localhost:5173")
public class MensajeController {

    private final IAService mensajeService;

    @MessageMapping("/mensaje")
    public void enviarMensaje(MensajeRequestDTO mensaje) {
        mensajeService.enviarMensajeYanalizar(mensaje);
    }


}
