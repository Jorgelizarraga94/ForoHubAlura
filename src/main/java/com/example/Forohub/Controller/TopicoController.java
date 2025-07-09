package com.example.Forohub.Controller;

import com.example.Forohub.Domain.Topico.DatosRegistroTopico;
import com.example.Forohub.Domain.Topico.GuardarTopico;
import com.example.Forohub.Domain.Topico.Topico;
import com.example.Forohub.Domain.Topico.TopicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topico")
public class TopicoController {
    @Autowired
    private TopicoRepository topicoRepository;
    @Autowired
    private GuardarTopico guardar;
    @Transactional
    @PostMapping
    public void crearTopico(@RequestBody @Valid DatosRegistroTopico datosTopico){
        Topico dato = guardar.guardar(datosTopico);
        System.out.println(dato);
        topicoRepository.save(dato);
    }
}
