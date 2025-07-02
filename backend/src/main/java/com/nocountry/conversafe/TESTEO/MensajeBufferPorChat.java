package com.nocountry.conversafe.TESTEO;

import com.nocountry.conversafe.Models.Dtos.Mensaje.MensajeParaIA;
import com.nocountry.conversafe.Models.Entities.Mensaje;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class MensajeBufferPorChat {

    private static final int LIMITE = 20;

    private final Map<Long, List<MensajeParaIA>> bufferPorChat = new HashMap<>();

    //agrega el dto a una lista.
    public synchronized void agregar(Long chatId, MensajeParaIA mensaje) {
        bufferPorChat
                .computeIfAbsent(chatId, k -> new ArrayList<>())
                .add(mensaje);
    }

    //pregunta si llego a la cantidad deseada de msg.
    public synchronized boolean estaListo(Long chatId) {
        return bufferPorChat.containsKey(chatId)
                && bufferPorChat.get(chatId).size() >= LIMITE;
    }

    //retorna la lista de los mensajes y vacia la lista.
    public synchronized List<MensajeParaIA> vaciar(Long chatId) {
        List<MensajeParaIA> lote = new ArrayList<>(bufferPorChat.getOrDefault(chatId, List.of()));
        bufferPorChat.put(chatId, new ArrayList<>()); // reiniciar buffer
        return lote;
    }
}