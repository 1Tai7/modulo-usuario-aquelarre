package com.example.aquelarre.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.aquelarre.repository.PostRepository;
import com.example.aquelarre.repository.UsuarioRepository;
import com.example.aquelarre.entity.Post;
import com.example.aquelarre.entity.Usuario;

@Service
public class PostService {


@Autowired
PostRepository postRepository;
UsuarioRepository usuarioRepository;

public List<Post> getPost(){
        return postRepository.findAll();
    }

    public Optional<Post> getPost(Long id){
        return postRepository.findById(id);
    }

    public void saveOrUpdate(Post post){
        postRepository.save(post);
    }

     public void delete(Long id){
        postRepository.deleteById(id);
    }

       public Optional<Usuario> getUsuarioByPost(Long id){
        return usuarioRepository.findById(id);
    }
}
