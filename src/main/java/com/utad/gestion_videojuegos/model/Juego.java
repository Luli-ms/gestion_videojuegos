package com.utad.gestion_videojuegos.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "juegos")
public class Juego {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String titulo;
    @Column(nullable = false)
    private String plataforma;
    @Column(nullable = false)
    private String genero;
    @Column(nullable = false)
    private Integer anio;
    @Column(nullable = false)
    private String desarrollador;

    private String editor = "";
    private Boolean esEdicionEspecial = false;
    private String estado = "";
    private Double valorEstimado = 0.00;
    private String notas = "";

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
}
