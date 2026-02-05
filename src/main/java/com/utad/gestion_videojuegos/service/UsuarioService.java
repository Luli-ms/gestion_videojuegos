package com.utad.gestion_videojuegos.service;

import com.utad.gestion_videojuegos.model.Juego;
import com.utad.gestion_videojuegos.model.Usuario;
import com.utad.gestion_videojuegos.repository.JuegoRepository;
import com.utad.gestion_videojuegos.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final JuegoRepository juegoRepository;
    UsuarioService(
            UsuarioRepository usuarioRepository,
            JuegoRepository juegoRepository
    ) {
        this.usuarioRepository = usuarioRepository;
        this.juegoRepository = juegoRepository;
    }

    /* Crear de usuario */
    public Usuario crearUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public List<Juego> findJuegosByIdUsuario(Long idUsuario) {
        Usuario usuario = usuarioRepository.findById(idUsuario).orElseThrow(
                () -> new RuntimeException("Usuario no encontrado")
        );
        return usuario.getJuegos();
    }

    /* Create */
    @Transactional
    public Juego crearJuegoDeUsuario(Long idUsuario, Juego juego) {
        Usuario foundUsuario = usuarioRepository.findById(idUsuario).orElseThrow(
                () -> new RuntimeException("Usuario no encontrado")
        );
        juego.setUsuario(foundUsuario);
        return juegoRepository.save(juego);
    }

    /* Listar usuarios */
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

}
