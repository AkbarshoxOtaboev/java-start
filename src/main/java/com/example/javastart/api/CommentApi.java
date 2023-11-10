package com.example.javastart.api;

import com.example.javastart.entities.Comments;
import com.example.javastart.services.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/comment")
@RequiredArgsConstructor
public class CommentApi {
    private final CommentService commentService;

    @PostMapping("/{postId}/save")
    public ResponseEntity<Comments> save(@PathVariable Long postId, @RequestBody Comments comments){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/comment/{postId}/save").toUriString());
        return ResponseEntity.created(uri).body(commentService.save(postId, comments));
    }

    @GetMapping("/{postId}")
    public ResponseEntity<Page<Comments>> fetchPostsByPostId(@PathVariable Long postId, Pageable pageable){
        return ResponseEntity.ok(commentService.fetchCommentsByPostId(postId, pageable));
    }
}
