package com.example.aquelarre.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "comentario")

public class Comentario {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long comentario;

    private String texto;

     @ManyToOne(targetEntity =  Usuario.class)
     @JoinColumn(name = "id_usuario")
      private Usuario usuario;

    @ManyToOne(targetEntity = Post.class)
    private Post post;

}
