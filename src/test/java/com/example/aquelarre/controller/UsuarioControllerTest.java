package com.example.aquelarre.controller;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.test.web.servlet.MockMvc;

import com.example.aquelarre.entity.Usuario;
import com.example.aquelarre.service.UsuarioService;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class UsuarioControllerTest {

    private MockMvc mockMvc;

    @Mock
    private UsuarioService usuarioService;

    @InjectMocks
    private UsuarioController usuarioController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(usuarioController).build();
    }

    @Test
    void testGetAllUsuarios() throws Exception {
        List<Usuario> usuarios = new ArrayList<>();
               usuarios.add(new Usuario(1L, "John", "jhonn", "password1","jhon1@gamil.com"));
               usuarios.add(new Usuario(2L, "John", "jhonn", "password2","jhon2@gamil.com"));
        
        when(usuarioService.getUsuario()).thenReturn(usuarios);

        mockMvc.perform(get("/api/v1/usuarios"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].id_usuario").value(1))
                .andExpect(jsonPath("$[0].nombre").value("John"))
                .andExpect(jsonPath("$[0].alias").value("jhonn"))
                .andExpect(jsonPath("$[0].contrasena").value("password1"))
                .andExpect(jsonPath("$[0].email").value("jhon1@gamil.com"));

        verify(usuarioService, times(1)).getUsuario();
    }

    @Test
    void testGetUsuarioById() throws Exception {
        Usuario usuario = new Usuario(1L, "John", "jhonn", "password1","jhon1@gamil.com");
        when(usuarioService.getUsuario(1L)).thenReturn(Optional.of(usuario));

        mockMvc.perform(get("/api/v1/usuarios/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id_usuario").value(1))
                .andExpect(jsonPath("$.nombre").value("John"))
                  .andExpect(jsonPath("$.alias").value("jhonn"))
                .andExpect(jsonPath("$.contrasena").value("password1"))
                .andExpect(jsonPath("$.email").value("jhon1@gamil.com"));

        verify(usuarioService, times(1)).getUsuario(1L);
    }

    @Test
    void testSaveOrUpdateUsuario() throws Exception {
        Usuario usuario = new Usuario(1L, "John", "jhonn", "password1","jhon1@gamil.com");
        doNothing().when(usuarioService).saveOrUpdate(any(Usuario.class));

        mockMvc.perform(post("/api/v1/usuarios")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id_usuario\": 1, \"nombre\": \"John\", \"alias\": \"jhonn\", \"contrasena\": \"password1\",\"email\": \"jhon1@gamil.com\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id_usuario").value(1))
                .andExpect(jsonPath("$.nombre").value("John"))
                  .andExpect(jsonPath("$.alias").value("jhonn"))
                .andExpect(jsonPath("$.contrasena").value("password1"))
                .andExpect(jsonPath("$.email").value("jhon1@gamil.com"));

        verify(usuarioService, times(1)).saveOrUpdate(any(Usuario.class));
    }

    @Test
    void testDeleteUsuario() throws Exception {
        doNothing().when(usuarioService).delete(1L);

        mockMvc.perform(delete("/api/v1/usuarios/1"))
                .andExpect(status().isOk());

        verify(usuarioService, times(1)).delete(1L);
    }
}


