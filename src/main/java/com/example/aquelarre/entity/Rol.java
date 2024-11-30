package com.example.aquelarre.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id; 
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "rol")

public class Rol {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id_rol;

    private String rol_admi;

    private String rol_escritor;

    private String rol_lector;

}
