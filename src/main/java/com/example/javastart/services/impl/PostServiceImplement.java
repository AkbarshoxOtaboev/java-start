package com.example.javastart.services.impl;

import com.example.javastart.entities.Post;
import com.example.javastart.entities.User;
import com.example.javastart.repositories.PostRepository;
import com.example.javastart.services.PostService;
import com.example.javastart.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class PostServiceImplement implements PostService {
    private final PostRepository postRepository;
    private final UserService userService;
    @Override
    public Post save(String username, Post post) {
        post.setUser(userService.fetchUserByUsername(username));
        return postRepository.save(post);
    }

    @Override
    public Page<Post> fetchAllPost(Pageable pageable) {
        return postRepository.findAll(pageable);
    }

    @Override
    public Page<Post> fetchPostsByUsername(String username, Pageable pageable) {
        User user = userService.fetchUserByUsername(username);
        return postRepository.findPostByUser(user, pageable);
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
