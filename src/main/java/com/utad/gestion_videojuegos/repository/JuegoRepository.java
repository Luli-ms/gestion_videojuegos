package com.utad.gestion_videojuegos.repository;

import com.utad.gestion_videojuegos.model.Juego;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JuegoRepository extends JpaRepository<Juego, Long> { }
