package com.example.Forohub.Domain.Topico;

public record DatosActualizacionTopico(
        Long id,
        String titulo,
        String mensaje,
        String autor
) {
    public DatosActualizacionTopico(Topico topico){
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getAutor());
    }
}
