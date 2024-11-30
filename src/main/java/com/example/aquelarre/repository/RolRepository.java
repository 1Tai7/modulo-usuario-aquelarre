package com.example.aquelarre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.aquelarre.entity.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, String> {


}
