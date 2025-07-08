package com.example.Forohub.Model.Topico;

import com.example.Forohub.Model.Curso.Curso;

public record DatosRegistroTopico(
    String titulo,
    String mensaje,
    String autor,
    Curso curso
) {
}
