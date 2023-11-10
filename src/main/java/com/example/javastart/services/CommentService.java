package com.example.javastart.services;

import com.example.javastart.entities.Comments;
import com.example.javastart.entities.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CommentService {

    Comments save(Long postId, Comments comments);

    Page<Comments> fetchCommentsByPostId(Long postId, Pageable pageable);


}
