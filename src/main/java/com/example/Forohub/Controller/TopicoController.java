package com.example.Forohub.Controller;

import com.example.Forohub.Model.Topico.DatosRegistroTopico;
import com.example.Forohub.Model.Topico.Topico;
import com.example.Forohub.Model.Topico.TopicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topico")
public class TopicoController {
    @Autowired
    private TopicoRepository topicoRepository;

    @Transactional
    @PostMapping
    public void crearTopico(@RequestBody @Valid DatosRegistroTopico datosTopico){
        topicoRepository.save(new Topico(datosTopico));
    }
}
