package com.example.Forohub.Controller;
import com.example.Forohub.Domain.Topico.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
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
    public List<Topico> mostrarTopicos(){
        return topicoRepository.findAll();
    }


    @GetMapping("/{id}")
    public Topico mostrarTopicoPorId(@PathVariable Long id){
        return topicoRepository.getReferenceById(id);
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
    @PutMapping("/{id}")
    public ResponseEntity actualizarTopico(@PathVariable @Valid Long id,@RequestBody DatosActualizacionTopico datosActualizacion){
            Topico topico = topicoRepository.getReferenceById(id);
            topico.actualizarTopico(datosActualizacion);
            return ResponseEntity.ok(new DatosActualizacionTopico(topico));
    }
}
