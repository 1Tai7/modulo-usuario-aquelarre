package com.example.aquelarre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.aquelarre.entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}
