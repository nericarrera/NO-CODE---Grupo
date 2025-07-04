package com.nocountry.conversafe.Controllers;

import com.nocountry.conversafe.Models.Dtos.Mensaje.MensajeRequestDTO;
import com.nocountry.conversafe.services.IAService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/msg")
@SecurityRequirement(name = "bearer-key")
public class MensajeController {

    private final IAService mensajeService;

    @MessageMapping("/mensaje")
    public void enviarMensaje(MensajeRequestDTO mensaje) {
        mensajeService.enviarMensajeYanalizar(mensaje);
    }
}
