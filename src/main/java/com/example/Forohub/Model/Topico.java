package com.example.Forohub.Model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Table(schema = "topicos")
@Entity(name= "topico")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private LocalDateTime fechaCreacion;
    private Estado estado;
    private String autor;
    private Curso curso;


}
