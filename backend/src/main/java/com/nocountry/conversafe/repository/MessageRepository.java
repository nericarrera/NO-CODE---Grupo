package com.nocountry.conversafe.repository;

import com.nocountry.conversafe.Models.Entities.Mensaje;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Mensaje, Long> {
}
