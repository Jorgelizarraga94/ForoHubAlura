package com.example.Forohub.Domain.Topico;
import com.example.Forohub.Domain.Curso.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuardarTopico{
    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private TopicoRepository topicoRepository;
    public Topico guardar(DatosRegistroTopico datos){
        var curso = cursoRepository.findById(datos.idCurso()).get();
        var consulta = new Topico(datos.titulo(),datos.mensaje(), datos.autor(), curso);
        return consulta;
    }

}
