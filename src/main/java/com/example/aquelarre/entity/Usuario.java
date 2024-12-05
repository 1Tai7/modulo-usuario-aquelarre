package com.example.aquelarre.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "usuario")

public class Usuario {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    public Long id_usuario;

    public String nombre;

    public String alias;

    public String contrasena;
    
    @Column(name = "id_rol",unique = false,nullable = false)
    public Long id_rol;

    @Column(name = "email",unique = true,nullable = false)
    public String email;

    @OneToMany(targetEntity = Post.class, fetch = FetchType.LAZY, mappedBy = "id_usuario")
    public List<Post> post;

    public Usuario(){}

  public Usuario(Long id_usuario, String nombre, String alias, String contrasena, String email){
    this.id_usuario = id_usuario;
    this.nombre = nombre;
    this.alias = alias;
    this.contrasena = contrasena;
    this.email = email;


  }
}


