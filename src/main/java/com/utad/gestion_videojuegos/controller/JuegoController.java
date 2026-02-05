package com.utad.gestion_videojuegos.controller;

import com.utad.gestion_videojuegos.model.Juego;
import com.utad.gestion_videojuegos.service.JuegoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/juegos")
class JuegoController {
    private final JuegoService juegoService;
    public JuegoController(JuegoService juegoService) { this.juegoService = juegoService; }

    /* Listar todos los juegos */
    @GetMapping
    public ResponseEntity<List<Juego>> findAll() {
        return ResponseEntity.ok(juegoService.findAll());
    }

    /* Actualizar juegos */
    @PutMapping
    public ResponseEntity<Juego> actualizarJuego(
            @RequestParam("idJuego") Long id,
            @RequestBody Juego juego
    ) {
        Optional<Juego> updatedJuego = juegoService.actualizarJuego(id, juego);
        return updatedJuego.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /* Eliminar juego */
    @DeleteMapping
    public ResponseEntity<Juego> eliminarJuego(@RequestParam("idJuego") Long id) {
        Optional<Juego> found = juegoService.findById(id);
        if (found.isPresent()) {
            juegoService.eliminarJuego(id);
            return ResponseEntity.ok(found.get());
        }
        return ResponseEntity.notFound().build();
    }
}
