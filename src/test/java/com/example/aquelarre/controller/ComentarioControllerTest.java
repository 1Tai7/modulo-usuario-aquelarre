package com.example.aquelarre.controller;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.aquelarre.entity.Comentario;
import com.example.aquelarre.service.ComentarioService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


class ComentarioControllerTest {


    private MockMvc mockMvc;

    @Mock
    private ComentarioService comentarioService;

    @InjectMocks
    private ComentarioController comentarioController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(comentarioController).build();

    }

    @Test
    void getAll_ReturnsListOfComentarios() {
        List<Comentario> comentarios = new ArrayList<>();
         comentarios.add(new Comentario(1L, "Comentario 1", 11L, 111L));
    
        when(comentarioService.getComentario()).thenReturn(comentarios);

        List<Comentario> result = comentarioController.getAll();

        assertEquals(1, result.size());
        verify(comentarioService, times(1)).getComentario();
    }

    @Test
    void getById_ReturnsComentario_WhenFound() {
        Long comentarioId = 1L;
        Comentario comentario = new Comentario(comentarioId, "Comentario 1", 11L, 111L);
        when(comentarioService.getComentario(comentarioId)).thenReturn(Optional.of(comentario));

        Optional<Comentario> result = comentarioController.getbyId(comentarioId);

        assertTrue(result.isPresent());
        assertEquals("Comentario 1", result.get().getTexto());
        verify(comentarioService, times(1)).getComentario(comentarioId);
    }

    @Test
    void getById_ReturnsEmpty_WhenNotFound() {
        Long comentarioId = 1L;
        when(comentarioService.getComentario(comentarioId)).thenReturn(Optional.empty());

        Optional<Comentario> result = comentarioController.getbyId(comentarioId);

        assertFalse(result.isPresent());
        verify(comentarioService, times(1)).getComentario(comentarioId);
    }

    @Test
    void saveUpdate_SavesComentario() {
        Comentario comentario = new Comentario(1L, "Nuevo comentario", 11L, 111L);
        doNothing().when(comentarioService).saveOrUpdate(comentario);

        Comentario result = comentarioController.saveUpdate(comentario);

        assertEquals("Nuevo comentario", result.getTexto());
        verify(comentarioService, times(1)).saveOrUpdate(comentario);
    }

    @Test
    void delete_DeletesComentario() {
        Long comentarioId = 1L;
        doNothing().when(comentarioService).delete(comentarioId);

        comentarioController.delete(comentarioId);

        verify(comentarioService, times(1)).delete(comentarioId);
    }
}
