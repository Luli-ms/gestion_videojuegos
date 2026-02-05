package com.utad.gestion_videojuegos.repository;

import com.utad.gestion_videojuegos.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> { }
