package com.nocountry.conversafe.Models.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Mensaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonBackReference
    private Usuario autor;

    private String contenido;

    //TR tiempo de respuesta 
    private String timestamp;

    //Modificacion para usar luego en metricas
    private int positivo;
    private int negativo;
    
    private String tipo;
    private Boolean fueChequeada;// es para saber si ya se chequea la respuesta a la pregunta.

    @ManyToOne(fetch = FetchType.LAZY)
    private Chat chat;

    @PrePersist
    protected void onCreate() {
        this.positivo=1;
        this.negativo=0;
        this.fueChequeada =false;
        this.timestamp = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }
}
