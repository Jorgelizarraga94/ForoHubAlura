package com.example.Forohub.Controller;

import com.example.Forohub.Domain.Curso.Curso;
import com.example.Forohub.Domain.Curso.CursoRepository;
import com.example.Forohub.Domain.Curso.DatosRegistroCurso;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/curso")
public class CursoController {
    @Autowired
    private CursoRepository cursoRepository;

    @Transactional
    @PostMapping
    public void crearCurso(@RequestBody @Valid DatosRegistroCurso curso){
        cursoRepository.save(new Curso(curso));
    }
}
