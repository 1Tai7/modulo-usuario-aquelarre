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
    private Long id_comentario;

    private String texto;

     @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

}
