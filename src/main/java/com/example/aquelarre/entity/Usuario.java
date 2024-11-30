package com.example.aquelarre.entity;

import jakarta.persistence.Column;
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
@Table(name = "usuario")

public class Usuario {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id_usuario;

    private String nombre;

    private String alias;

    private String contrasena;

    private String id_rol;

    @Column(name = "email",unique = true,nullable = false)
    private String email;

   

}


