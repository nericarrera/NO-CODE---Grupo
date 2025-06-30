package com.nocountry.conversafe.repository;

import com.nocountry.conversafe.Models.Entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Usuario, Long> {
}
