package com.academia.fikefino.repositories;

import com.academia.fikefino.entities.Papeis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PapeisRespository extends JpaRepository<Papeis, String> {
    Papeis findByNome(String nome);
}
