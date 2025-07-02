package com.nocountry.conversafe.TESTEO;

import com.nocountry.conversafe.Models.Dtos.Chat.AnalisisDTO;
import com.nocountry.conversafe.Models.Dtos.Mensaje.MensajeParaIA;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chat")
@RequiredArgsConstructor
public class TestController {

    private final GeminiAI geminiAI;

    @PostMapping("/preguntar/{id}")
    public ResponseEntity<AnalisisDTO> preguntar(@PathVariable("id")Long id,@RequestBody List<MensajeParaIA> mensajes) {
        AnalisisDTO respuesta = geminiAI.generarRespuesta(id,mensajes);
        return ResponseEntity.ok(respuesta);
    }


}
