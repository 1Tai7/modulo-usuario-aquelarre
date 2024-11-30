package com.example.aquelarre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.aquelarre.entity.Comentario;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Long>{

}
