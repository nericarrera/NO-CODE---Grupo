package com.nocountry.conversafe.TESTEO;


import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;
import com.nocountry.conversafe.Models.Dtos.Chat.AnalisisDTO;
import com.nocountry.conversafe.Models.Dtos.Mensaje.MensajeParaIA;
import com.nocountry.conversafe.Models.Mappers.IDataType;
import com.nocountry.conversafe.Models.Mappers.ResponseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class GeminiAI {

    private final IDataType mapper;

    private final SimpMessagingTemplate messagingTemplate;

    @Value("${GOOGLE_API_KEY}")
    private String apiKey;

    @Value("${prompt.ia}")
    private String prompt;

    public void enviarAnalisis(Long chatId,List<MensajeParaIA> mensajes) {
        AnalisisDTO analisis=generarRespuesta(chatId,mensajes);
        messagingTemplate.convertAndSend("/topic/analisis/" + chatId, analisis);
    }

    public AnalisisDTO generarRespuesta(Long chatId,List<MensajeParaIA> mensajes){

    Client client = Client.builder().apiKey(apiKey).build();

        String texto = mensajes.stream()
                .map(Record::toString)
                .collect(Collectors.joining("\n"));

        GenerateContentResponse response =
                client.models.generateContent(
                        "gemini-1.5-flash",
                        prompt+" el chatId es: "+chatId+"y la lista es:"+texto,
                        null);

        String respuesta=response.text().replaceAll("^```json\\s*", "")   // Quita ```json al inicio
                .replaceAll("\\s*```$", "")        // Quita ``` al final
                .trim();
        try {
             return mapper.getData(respuesta, AnalisisDTO.class);
        } catch (RuntimeException e) {
            throw new RuntimeException("Error al parsear JSON de la IA: " + respuesta, e);
        }
    }

}
