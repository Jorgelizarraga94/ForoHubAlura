package com.example.Forohub.Model.Curso;

import jakarta.persistence.*;

@Table(schema = "cursos")
@Entity(name= "curso")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    @Enumerated(EnumType.STRING)
    private Categoria categoria;
}
