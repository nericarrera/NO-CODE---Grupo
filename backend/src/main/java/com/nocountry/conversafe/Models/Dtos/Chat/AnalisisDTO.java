package com.nocountry.conversafe.Models.Dtos.Chat;


public record AnalisisDTO(
        String posibleSugerencia, //en el caso q sea necesaria si no q devuelva un null.
        Integer esNegativo,//si es negativo el msg que sea 1 si no q sea 0.
        Integer esPregunta //si es pregunta el msg que sea 1 si no q sea 0.
){}
