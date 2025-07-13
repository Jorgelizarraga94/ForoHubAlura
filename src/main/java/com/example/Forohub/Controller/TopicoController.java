package com.example.Forohub.Controller;

import com.example.Forohub.Domain.Topico.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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

    @GetMapping
    public void mostrarTopicos(){
        List<Topico> listaTopicos = topicoRepository.findAll();
        for (Topico topico : listaTopicos){
            System.out.println(topico.toString());
        }
    }


    @GetMapping("/{id}")
    public String mostrarTopicoPorId(@PathVariable Long id){
        Topico topico = topicoRepository.getReferenceById(id);
        System.out.println(topico.toString());
        return topico.toString() ;
    }

    @Transactional
    @DeleteMapping("/{id}")
    public void EliminarTopico(@PathVariable Long id){
        if(topicoRepository.existsById(id)){
            topicoRepository.deleteById(id);
        }
        else{
            System.out.println("No se encuentra Topico a Eliminar");
        }
    }

    @Transactional
    @PutMapping
    public ResponseEntity actualizarTopico(@RequestBody @Valid DatosActualizacionTopico datosActualizacion){
        Topico topico = topicoRepository.getReferenceById(datosActualizacion.id());
        topico.actualizarTopico(datosActualizacion);

        return ResponseEntity.ok(new DatosActualizacionTopico(topico));
    }
}
