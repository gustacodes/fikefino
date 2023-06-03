package com.academia.fikefino.repositories;

import com.academia.fikefino.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin findByUsuario(String usuario);
}
