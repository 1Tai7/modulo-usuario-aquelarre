package com.example.aquelarre.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
    
    private String id_usuario;

    @OneToMany
    private List<Comentario> comentario;

       @ManyToOne
       @JoinColumn(name = "usuario")
       private Usuario usuario;
}
