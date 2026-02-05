package com.utad.gestion_videojuegos.controller;

import com.utad.gestion_videojuegos.model.Juego;
import com.utad.gestion_videojuegos.model.Usuario;
import com.utad.gestion_videojuegos.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
class UsuarioController {
    private final UsuarioService usuarioService;
    public UsuarioController(UsuarioService usuarioService) { this.usuarioService = usuarioService; }

    @PostMapping
    public Usuario crearUsuario(@RequestBody Usuario usuario) {
        return usuarioService.crearUsuario(usuario);
    }

    @GetMapping
    public List<Usuario> findAll() {
        return usuarioService.findAll();
    }

    /* Obtener juegos por usuario */
    @GetMapping("/{idUsuario}/juegos")
    public ResponseEntity<List<Juego>> findJuegosByIdUsuario(@PathVariable("idUsuario") Long id) {
        return ResponseEntity.ok(usuarioService.findJuegosByIdUsuario(id));
    }

    /* Crear juegos */
    @PostMapping("/{idUsuario}/juegos")
    public ResponseEntity<Juego> crearJuegoDeUsuario(
            @PathVariable Long idUsuario,
            @RequestBody Juego juego
    ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
                usuarioService.crearJuegoDeUsuario(idUsuario, juego)
        );
    }
}
