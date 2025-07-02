package com.nocountry.conversafe.Models.Dtos.Chat;

import java.util.List;

public record AnalisisDTO(
        Long chatId,
        String resumen, // breve resumen general
        List<String> sugerencias, // observaciones simples
        String estadoGeneral // opcional: "bueno", "neutro", "mejorar"
) {}
