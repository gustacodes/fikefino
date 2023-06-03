package com.academia.fikefino.repositories;

import com.academia.fikefino.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin findByUsuario(String usuario);
}
