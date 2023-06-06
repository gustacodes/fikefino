package com.academia.fikefino.repositories;

import com.academia.fikefino.entities.Planos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanosRepository extends JpaRepository<Planos, Long> {

}
