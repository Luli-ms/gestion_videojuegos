package com.utad.gestion_videojuegos.service;

import com.utad.gestion_videojuegos.model.Juego;
import com.utad.gestion_videojuegos.repository.JuegoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true) // Por defecto, todas las transacciones son read-only
public class JuegoService {
    private final JuegoRepository juegoRepository;
    public JuegoService(JuegoRepository juegoRepository) { this.juegoRepository = juegoRepository; }

    /* Listar todos los juegos */
    public List<Juego> findAll() {
        return juegoRepository.findAll();
    }

    public Optional<Juego> findById(Long id) {
        return juegoRepository.findById(id);
    }

    /* Update */
    @Transactional
    public Optional<Juego> actualizarJuego(Long idJuego, Juego juego) {
        return juegoRepository.findById(idJuego)
                .map( found -> {
                    if (juego.getTitulo() != null) found.setTitulo(juego.getTitulo());
                    if (juego.getPlataforma() != null) found.setPlataforma(juego.getPlataforma());
                    if (juego.getGenero() != null) found.setGenero(juego.getGenero());
                    if (juego.getAnio() != null) found.setAnio(juego.getAnio());
                    if (juego.getDesarrollador() != null) found.setDesarrollador(juego.getDesarrollador());
                    if (juego.getEditor() != null) found.setEditor(juego.getEditor());
                    if (juego.getEsEdicionEspecial() != null) found.setEsEdicionEspecial(juego.getEsEdicionEspecial());
                    if (juego.getEstado() != null) found.setEstado(juego.getEstado());
                    if (juego.getValorEstimado() != null) found.setValorEstimado(juego.getValorEstimado());
                    if (juego.getNotas() != null) found.setNotas(juego.getNotas());

                    return juegoRepository.save(found);
                }
        );
    }

    /* Delete */
    @Transactional
    public void eliminarJuego(Long idJuego) {
        Juego foundJuego = juegoRepository.findById(idJuego).orElseThrow(
                () -> new RuntimeException("Juego no encontrado")
        );
        juegoRepository.delete(foundJuego);
    }
}
