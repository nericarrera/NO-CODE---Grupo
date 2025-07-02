package com.nocountry.conversafe.Models.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

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
    //no estoy seguro si es necesario guardar por ahora el contenido de los mensajes. Seria útil si solo son lon
    private String contenido;
    //TR tiempo de respuesta 
    private TR timestamp;
    //Modificacion para usar luego en metricas
    private int positivo
    private int negativo
    
    //private String tipo;
    //private String tono;
    //private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    private Chat chat;

    @PrePersist
    protected void onCreate() {
        this.timestamp = LocalDateTime.now();
    }
}
