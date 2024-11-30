package com.example.aquelarre.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.aquelarre.entity.Post;
import com.example.aquelarre.service.PostService;

@RestController
@RequestMapping(path = "api/v1/post")
public class PostController {

        @Autowired
    private final PostService postService;
    public PostController(PostService postService){
        this.postService = postService;
    }

    @GetMapping
    public List<Post> getAll(){

        return postService.getPost();
    }

   
    @GetMapping("/{postId}")
    public Optional<Post> getbyId(@PathVariable("postId") Long postId){

        return postService.getPost(postId);
    }

    // @PostMapping
    // public Post saveUpdate(@RequestBody Post post){
    //     // postService.getUsuarioByPost(post);
    //     postService.saveOrUpdate(post);

    //     return post;
    // }

       @DeleteMapping("/{postId}")
    public void delete(@PathVariable("postId") Long postId){

        postService.delete(postId);
    }


}
