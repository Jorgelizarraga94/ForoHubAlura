package com.example.Forohub.Domain.Topico;

import com.example.Forohub.Domain.Curso.Curso;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Table(name = "topicos")
@Entity(name= "topico")
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private LocalDateTime fecha_creacion;
    @Enumerated(EnumType.STRING)
    private Estado estado;
    private String autor;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curso_id")
    private Curso curso;

    public Topico(){}

    public Topico(String titulo, String mensaje, String autor, Curso curso) {
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.fecha_creacion = LocalDateTime.now();
        this.estado = Estado.NUEVO;
        this.autor = autor;
        this.curso = curso;
    }

    public Topico(String titulo, String mensaje, LocalDateTime fecha_creacion, Estado estado, String autor, Curso curso) {
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.fecha_creacion = fecha_creacion;
        this.estado = estado;
        this.autor = autor;
        this.curso = curso;
    }
    public void actualizarTopico(DatosActualizacionTopico datos){
        if(titulo != null){
            this.titulo = datos.titulo();
        }
        if(mensaje != null){
            this.mensaje = datos.mensaje();
        }
        if(autor != null){
            this.autor = datos.autor();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public LocalDateTime getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(LocalDateTime fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return "Topico{" +
                "titulo='" + titulo + '\'' +
                ", mensaje='" + mensaje + '\'' +
                ", fecha_creacion=" + fecha_creacion +
                ", estado=" + estado +
                ", autor='" + autor + '\'' +
                ", curso=" + curso.getNombre() +
                '}';
    }

}
