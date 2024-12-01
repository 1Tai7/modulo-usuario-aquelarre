package com.example.aquelarre.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
    
    @OneToMany(targetEntity = Comentario.class, fetch = FetchType.LAZY, mappedBy = "post")
    private List<Comentario> comentario;

    @ManyToOne(targetEntity = Usuario.class)
    private Usuario usuario;
}
