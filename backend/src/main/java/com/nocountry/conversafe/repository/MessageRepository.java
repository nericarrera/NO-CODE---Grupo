package com.nocountry.conversafe.repository;

import com.nocountry.conversafe.Models.Entities.Chat;
import com.nocountry.conversafe.Models.Entities.Mensaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MessageRepository extends JpaRepository<Mensaje, Long> {
    List<Mensaje> findByTipoAndFueChequeadaFalse(String tipo);
    List<Mensaje> findTop5ByChatIdOrderByIdDesc(Long chatId);

    //busca los mensajes posteriores a un mensaje.
    @Query("SELECT m FROM Mensaje m WHERE m.chat = :chat AND m.id > :preguntaId ORDER BY m.id ASC")
    List<Mensaje> findMensajesPosteriores(@Param("chat") Chat chat, @Param("preguntaId") Long preguntaId);
}
