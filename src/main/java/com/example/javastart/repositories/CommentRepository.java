package com.example.javastart.repositories;

import com.example.javastart.entities.Comments;
import com.example.javastart.entities.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comments, Long> {
    Page<Comments> findCommentsByPost(Post post, Pageable pageable);
}
