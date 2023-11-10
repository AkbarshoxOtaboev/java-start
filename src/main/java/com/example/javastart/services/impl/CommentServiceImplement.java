package com.example.javastart.services.impl;

import com.example.javastart.entities.Comments;
import com.example.javastart.entities.Post;
import com.example.javastart.repositories.CommentRepository;
import com.example.javastart.services.CommentService;
import com.example.javastart.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentServiceImplement implements CommentService {
    private final CommentRepository commentRepository;
    private final PostService postService;
    @Override
    public Comments save(Long postId, Comments comments) {
        Post post = postService.fetchPostById(postId);
        comments.setPost(post);
        return commentRepository.save(comments);
    }

    @Override
    public Page<Comments> fetchCommentsByPostId(Long postId, Pageable pageable) {
        Post post = postService.fetchPostById(postId);
        return commentRepository.findCommentsByPost(post, pageable);
    }
}
