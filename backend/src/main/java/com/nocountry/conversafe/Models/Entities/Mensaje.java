package com.nocountry.conversafe.Models.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Mensaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonBackReference
    private Usuario autor;

    private String contenido;

    private LocalDateTime timestamp;

    @PrePersist
    protected void onCreate() {
        //se hace esto cuando se crea una nueva entidad.
        this.timestamp = LocalDateTime.now();
    }
}
