package com.example.javastart.services;

import com.example.javastart.entities.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PostService {

    Post save(String username,Post post);

    Post fetchPostById(Long id);

    Page<Post> fetchAllPost(Pageable pageable);

    Page<Post> fetchPostsByUsername(String username, Pageable pageable);

    void update(Post post, Long postId);

    void delete(Long postId);
}
