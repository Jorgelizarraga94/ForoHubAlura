package com.example.Forohub.Model.Topico;

import com.example.Forohub.Model.Curso.Curso;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Table(schema = "topicos")
@Entity(name= "topico")
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private LocalDateTime fechaCreacion;
    @Enumerated(EnumType.STRING)
    private Estado estado;
    private String autor;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curso_id")
    private Curso curso;

    public Topico(@Valid DatosRegistroTopico datosTopico) {
        this.id = id;
        this.titulo = datosTopico.titulo();
        this.mensaje = datosTopico.mensaje();
        this.fechaCreacion = LocalDateTime.now();
        this.estado = Estado.NUEVO;
        this.autor = datosTopico.autor();
        this.curso = datosTopico.curso();
    }


}
