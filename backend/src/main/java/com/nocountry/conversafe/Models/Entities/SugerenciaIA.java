package com.nocountry.conversafe.Models.Entities;

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
public class SugerenciaIA {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo; // Ej: "mensajeSinRespuesta", "tonoNegativo", "sinResponsable"
    private String descripcion;

    @ManyToOne
    private Mensaje mensajeRelacionado;

    private LocalDateTime sugeridoEn;

    @PrePersist
    protected void onCreate() {
        //se hace esto cuando se crea una nueva entidad.
        this.sugeridoEn = LocalDateTime.now();
    }
}
