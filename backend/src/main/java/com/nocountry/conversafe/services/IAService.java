package com.nocountry.conversafe.services;


import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;
import com.nocountry.conversafe.Models.Dtos.Chat.AnalisisDTO;
import com.nocountry.conversafe.Models.Dtos.Mensaje.MensajeRequestDTO;
import com.nocountry.conversafe.Models.Entities.Mensaje;
import com.nocountry.conversafe.Models.Mappers.IDataType;
import com.nocountry.conversafe.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IAService {

    private final IDataType mapper;
    private final MessageRepository messageRepository;
    private final MensajeService mensajeService;
    private static final Long ID_CHATBOT=2L;

    @Value("${GOOGLE_API_KEY}")
    private String apiKey;

    @Value("${prompt.ia2}")
    private String promptPregRespondida;

    @Value("${prompt.ia}")
    private String promptParaMensaje;

    public void enviarMensajeYanalizar(MensajeRequestDTO mensaje){

        Mensaje saved=mensajeService.enviarMensaje(mensaje);

        enviarAnalisisMensaje(mensaje.chatId(),saved);
    }

    public AnalisisDTO enviarAnalisisMensaje(Long chatId, Mensaje mensaje) {
        AnalisisDTO analisis = generarRespuestaMensaje(chatId,mensaje.getContenido());

        if(analisis.esNegativo()==1){
            mensaje.setNegativo(1);
            mensaje.setPositivo(0);//todso los msg por default son 1 en postivo.
            messageRepository.save(mensaje);
        }

        if(analisis.esPregunta()==1){
            mensaje.setTipo("pregunta");
            messageRepository.save(mensaje);
        }

        if(analisis.posibleSugerencia()!=null&&!"null".equalsIgnoreCase(analisis.posibleSugerencia().trim())){
            mensajeService.enviarMensaje(new MensajeRequestDTO(ID_CHATBOT
                    ,chatId,analisis.posibleSugerencia()));
            System.out.println("sugerencia sobre el mensaje '"+mensaje.getContenido()+"':"+analisis.posibleSugerencia());
        }
        return analisis;
    }

    public AnalisisDTO generarRespuestaMensaje(Long chatId,String mensaje){

        List<String>mensajes=messageRepository.findTop5ByChatIdOrderByIdDesc(chatId)
                .stream().map(Mensaje::getContenido)
                .toList();

        String contexto = String.join("\n", mensajes);
        String promptFinal = String.format(promptParaMensaje, contexto, mensaje);

        Client client = Client.builder().apiKey(apiKey).build();

        GenerateContentResponse response =
                client.models.generateContent(
                        "gemini-2.0-flash",
                        promptFinal,
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

    //cada x tiempo manda un mensaje al chat si hay preguntas sin responder.
    @Scheduled(fixedRate = 60000) // cada 60 segundos
    public void verificarMensajesNoRespondidos() {
        List<Mensaje>preguntasSinResponder=messageRepository.findByTipoAndFueChequeadaFalse("pregunta");
        for(Mensaje pregunta:preguntasSinResponder){

            List<String>mensajesPosteriores=messageRepository.findMensajesPosteriores(pregunta.getChat(),pregunta.getId())
                            .stream().map(Mensaje::getContenido).toList();

            if(mensajesPosteriores.size()>=2){
                if(!fueRespondida(pregunta.getContenido(),mensajesPosteriores)){
                    mensajeService.enviarMensaje(new MensajeRequestDTO(ID_CHATBOT
                            ,pregunta.getChat().getId()
                            ,"La pregunta '"+pregunta.getContenido()+"' no ha sido respondida aún."));
                }
                pregunta.setFueChequeada(true);
                messageRepository.save(pregunta);
            }
        }
    }

    private Boolean fueRespondida(String pregunta,List<String>mensajesPosteriores){
        Client client = Client.builder().apiKey(apiKey).build();

        String mensajes = String.join("\n", mensajesPosteriores);
        String promptFinal = String.format(promptPregRespondida, pregunta, mensajes);

        GenerateContentResponse response =
                client.models.generateContent(
                        "gemini-2.0-flash",
                        promptFinal,
                        null);

        String respuesta=response.text().replaceAll("^```json\\s*", "")   // Quita ```json al inicio
                .replaceAll("\\s*```$", "")        // Quita ``` al final
                .trim();
        return respuesta.equals("true");
    }

}
