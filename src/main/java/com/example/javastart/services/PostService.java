package com.example.javastart.services;

import com.example.javastart.entities.Post;

import java.util.List;

public interface PostService {

    Post save(Post post);

    List<Post> fetchAllPost();

    void update(Post post, Long postId);

    void delete(Long postId);
}
