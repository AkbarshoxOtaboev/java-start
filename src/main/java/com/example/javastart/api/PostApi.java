package com.example.javastart.api;

import com.example.javastart.entities.Post;
import com.example.javastart.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/post")
@RequiredArgsConstructor
public class PostApi {

    private final PostService postService;

    @PostMapping("/{username}/save")
    public ResponseEntity<Post> save(@PathVariable String username, @RequestBody Post post){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/post/{username}/save").toUriString());
        return ResponseEntity.created(uri).body(postService.save(username,post));
    }

    @GetMapping("/fetchAll")
    public ResponseEntity<Page<Post>> fetchAllPosts(Pageable pageable){
        return ResponseEntity.ok(postService.fetchAllPost(pageable));
    }

    @GetMapping("/fetchByUsername/{username}")
    public ResponseEntity<Page<Post>> fetchPostsByUsername(@PathVariable String username, Pageable pageable){
        return ResponseEntity.ok(postService.fetchPostsByUsername(username, pageable));
    }

}
