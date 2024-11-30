package com.example.aquelarre.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.aquelarre.repository.ComentarioRepository;
import com.example.aquelarre.entity.Comentario;


@Service
public class ComentarioService {

     @Autowired
    ComentarioRepository comentarioRepository;

    public List<Comentario> getComentario(){
        return comentarioRepository.findAll();
    }

    public Optional<Comentario> getComentario(Long id){
        return comentarioRepository.findById(id);
    }

    public void saveOrUpdate(Comentario comentario){
        comentarioRepository.save(comentario);
    }

     public void delete(Long id){
        comentarioRepository.deleteById(id);
    }

}
