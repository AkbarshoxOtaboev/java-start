package com.example.javastart.repositories;

import com.example.javastart.entities.Post;
import com.example.javastart.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

    Page<Post> findPostByUser(User user, Pageable pageable);




}
