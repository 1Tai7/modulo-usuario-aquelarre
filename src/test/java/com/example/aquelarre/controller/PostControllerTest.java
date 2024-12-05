package com.example.aquelarre.controller;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;
import java.util.Optional;


import com.example.aquelarre.entity.Post;
import com.example.aquelarre.service.PostService;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class PostControllerTest {

       @Autowired
    private MockMvc mockMvc;

    @Mock
    private PostService postService;

    @InjectMocks
    private PostController postController;

    private ObjectMapper objectMapper = new ObjectMapper(); 


    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(postController).build();
    }

    @Test
    void testGetAllPosts() throws Exception {
      List<Post> post1 = List.of(new Post(1L, "#hashtag1", "alias1", "hola texto 1"));
    //   List<Post> post2 = List.of(new Post(2L, "#hashtag2", "alias2", "hola texto 2"));

        when(postService.getPost()).thenReturn(post1);

        mockMvc.perform(get("/api/v1/post"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].id_post").value(1))
                .andExpect(jsonPath("$[0].hashtag").value("#hashtag1"))
                .andExpect(jsonPath("$[0].alias").value("alias1"))
                .andExpect(jsonPath("$[0].texto").value("hola texto 1"));

        verify(postService, times(1)).getPost();
    }

    @Test
    void testGetPostById() throws Exception {
        // Given
        Post post = new Post(1L, "#hashtag1", "alias1", "hola texto 1");
        when(postService.getPost(1L)).thenReturn(Optional.of(post));

        // When & Then
        mockMvc.perform(get("/api/v1/post/{postId}", 1L))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id_post").value(1))
                .andExpect(jsonPath("$.hashtag").value("#hashtag1"))
                .andExpect(jsonPath("$.alias").value("alias1"))
                .andExpect(jsonPath("$.texto").value("hola texto 1"));

        verify(postService, times(1)).getPost(1L);
    }

    @Test
    void testSaveOrUpdatePost() throws Exception {
        Post post = new Post(1L, "#hashtag1", "alias1", "hola texto 1");
        doNothing().when(postService).saveOrUpdate(post);

        mockMvc.perform(post("/api/v1/post")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(post)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id_post").value(1))
                .andExpect(jsonPath("$.hashtag").value("#hashtag1"))
                .andExpect(jsonPath("$.alias").value("alias1"))
                .andExpect(jsonPath("$.texto").value("hola texto 1"));

        verify(postService, times(1)).saveOrUpdate(post);
    }

    @Test
    void testDeletePost() throws Exception {
        // When & Then
        mockMvc.perform(delete("/api/v1/post/{postId}", 1L))
                .andExpect(status().isOk());

        verify(postService, times(1)).delete(1L);
    }
}
