package com.example.Forohub.Domain.Topico;

public record DatosActualizacionTopico(
        String titulo,
        String mensaje,
        String autor
) {
    public DatosActualizacionTopico(Topico topico){
        this(topico.getTitulo(), topico.getMensaje(), topico.getAutor());
    }
}
