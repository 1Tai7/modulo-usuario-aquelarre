package com.example.aquelarre.entity;

import java.util.List;

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
@Table(name = "post")

public class Post {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id_post;

    private String hashtag;

    private String alias;
    private String texto;
    
    @OneToMany(targetEntity = Comentario.class, fetch = FetchType.LAZY)
    private List<Comentario> comentario;
    private Long id_usuario;

    public Post(){}

    public Post(Long id_post, String hashtag, String alias, String texto){
    this.id_post = id_post;
    this.hashtag = hashtag;
    this.alias = alias;
    this.texto = texto;
  }
}
