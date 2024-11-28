package com.example.aquelarre.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.aquelarre.repository.UsuarioRepository;
import com.example.aquelarre.entity.Usuario;


@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public List<Usuario> getUsuario(){
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> getUsuario(Long id){
        return usuarioRepository.findById(id);
    }

    public void saveOrUpdate(Usuario usuario){
        usuarioRepository.save(usuario);
    }

     public void delete(Long id){
        usuarioRepository.deleteById(id);
    }
}
