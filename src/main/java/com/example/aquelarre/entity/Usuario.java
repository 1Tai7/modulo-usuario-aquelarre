package com.example.aquelarre.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "usuario")

public class Usuario {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id_usuario;

    private String nombre;

    private String alias;

    private String contrasena;

    @OneToOne(targetEntity = Usuario.class, cascade = CascadeType.PERSIST)
    private Rol rol;

    @Column(name = "email",unique = true,nullable = false)
    private String email;

    @OneToMany(targetEntity = Post.class, fetch = FetchType.LAZY, mappedBy = "usuario")
  private List<Post> post;

}


