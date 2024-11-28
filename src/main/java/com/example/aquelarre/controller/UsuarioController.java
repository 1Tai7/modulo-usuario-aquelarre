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

import com.example.aquelarre.entity.Usuario;
import com.example.aquelarre.service.UsuarioService;

@RestController
@RequestMapping(path = "api/v1/usuarios")
public class UsuarioController {

    @Autowired
    private final UsuarioService usuarioService;
    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<Usuario> getAll(){

        return usuarioService.getUsuario();
    }

    @GetMapping("/{usuarioId}")
    public Optional<Usuario> getbyId(@PathVariable("usuarioId") Long usuarioId){

        return usuarioService.getUsuario(usuarioId);
    }

    @PostMapping
    public Usuario saveUpdate(@RequestBody Usuario usuario){

        usuarioService.saveOrUpdate(usuario);
        return usuario;
    }

       @DeleteMapping("/{usuarioId}")
    public void delete(@PathVariable("usuarioId") Long usuarioId){

        usuarioService.delete(usuarioId);
    }
}
