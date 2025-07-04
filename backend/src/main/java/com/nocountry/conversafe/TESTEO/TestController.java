package com.nocountry.conversafe.TESTEO;

import com.nocountry.conversafe.Models.Dtos.Chat.AnalisisDTO;
import com.nocountry.conversafe.Models.Entities.Mensaje;
import com.nocountry.conversafe.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chat")
@RequiredArgsConstructor
public class TestController {

    private final com.nocountry.conversafe.services.IAService IAService;
    private final MessageRepository messageRepository;

    @PostMapping("/preguntar/{id}/{id_msg}")
    //Crea un evento con el analisisDTO
    public ResponseEntity<AnalisisDTO> preguntar(@PathVariable("id")Long id_chat,@PathVariable("id_msg")Long id) {
        Mensaje mensaje=messageRepository.findById(id).orElseThrow(()->new RuntimeException("no se encontro el msg"));
        AnalisisDTO respuesta = IAService.enviarAnalisisMensaje(id_chat,mensaje);
        return ResponseEntity.ok(respuesta);
    }
}
