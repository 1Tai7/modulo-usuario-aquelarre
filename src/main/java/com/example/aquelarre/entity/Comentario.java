package com.example.aquelarre.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "comentario")

public class Comentario {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id_comentario;

    private String texto;
    private Long id_usuario;
    private Long id_post;

    public Comentario(){
        
    }

      public Comentario(Long id_comentario, String texto, Long id_usuario, Long id_post){
    this.id_usuario = id_usuario;
    this.texto = texto;
    this.id_usuario = id_usuario;
    this.id_post = id_post;
  }

}
