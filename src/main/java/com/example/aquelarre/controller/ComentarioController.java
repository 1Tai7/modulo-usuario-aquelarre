package com.example.aquelarre.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.aquelarre.entity.Comentario;
import com.example.aquelarre.service.ComentarioService;


@RestController
@RequestMapping(path = "api/v1/comentarios")
public class ComentarioController {
    
        @Autowired
    private final ComentarioService comentarioService;
    public ComentarioController(ComentarioService comentarioService){
        this.comentarioService = comentarioService;
    }

    @GetMapping
    public List<Comentario> getAll(){

        return comentarioService.getComentario();
    }

   
    @GetMapping("/{comentarioId}")
    public Optional<Comentario> getbyId(@PathVariable("comentarioId") Long comentarioId){

        return comentarioService.getComentario(comentarioId);
    }

    @PostMapping
    public Comentario saveUpdate(@RequestBody Comentario comentario){

        comentarioService.saveOrUpdate(comentario);

        return comentario;
    }

       @DeleteMapping("/{comentarioId}")
    public void delete(@PathVariable("comentarioId") Long comentarioId){

        comentarioService.delete(comentarioId);
    }

}
