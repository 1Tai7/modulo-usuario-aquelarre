package com.example.aquelarre.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.aquelarre.repository.RolRepository;
import com.example.aquelarre.entity.Rol;


@Service
public class RolService {

    @Autowired
    RolRepository rolRepository;

    public List<Rol> getRol() {
        return rolRepository.findAll();
    }

    public Optional<Rol> getRol(String nombre) {
        return rolRepository.findById(nombre);
    }

    public void saveRol(Rol rol) {
        rolRepository.save(rol);
    }

    public void deleteRol(String nombre) {
        rolRepository.deleteById(nombre);
    }

}
