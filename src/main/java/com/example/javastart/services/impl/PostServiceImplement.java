package com.example.javastart.services.impl;

import com.example.javastart.entities.Post;
import com.example.javastart.repositories.PostRepository;
import com.example.javastart.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class PostServiceImplement implements PostService {
    private final PostRepository postRepository;
    @Override
    public Post save(Post post) {
        return postRepository.save(post);
    }

    @Override
    public List<Post> fetchAllPost() {
        return postRepository.findAll();
    }

    @Override
    public void update(Post post, Long postId) {
        Post updPost = postRepository.findById(postId).orElseThrow();
        updPost.setBody(post.getBody());
        updPost.setTitle(post.getTitle());
        updPost.setLikes(post.getLikes());
        updPost.setDislikes(post.getDislikes());
        postRepository.saveAndFlush(updPost);
    }

    @Override
    public void delete(Long postId) {
        postRepository.delete(postRepository.findById(postId).orElseThrow());
    }
}
