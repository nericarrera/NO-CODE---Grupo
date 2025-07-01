package com.nocountry.conversafe.repository;

import com.nocountry.conversafe.Models.Entities.Chat;
import com.nocountry.conversafe.Models.Entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChatRepository extends JpaRepository<Chat, Long> {
    List<Chat> findAllByParticipantesContains(Usuario usuario);
}
