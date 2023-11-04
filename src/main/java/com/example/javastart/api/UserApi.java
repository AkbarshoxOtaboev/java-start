package com.example.javastart.api;

import com.example.javastart.entities.User;
import com.example.javastart.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserApi {

    private final UserService userService;

    @PostMapping("/save")
    public ResponseEntity<User> save(@RequestBody User user){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toUriString());
        return ResponseEntity.created(uri).body(userService.save(user));
    }

    @GetMapping("/{username}")
    public ResponseEntity<User> fetchUserByUsername(@PathVariable String username){
        return ResponseEntity.ok(userService.fetchUserByUsername(username));
    }

    @GetMapping("/fetchAllUsers")
    public ResponseEntity<List<User>> fetchAllUsers(){
        return ResponseEntity.ok(userService.fetchAllUsers());
    }

    @PatchMapping("/update/{username}")
    public ResponseEntity<User> updateUser(@PathVariable String username, @RequestBody User user){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/update/{username}").toUriString());
        return ResponseEntity.created(uri).body(userService.update(username, user));
    }

    @DeleteMapping("/delete/{username}")
    public ResponseEntity<String> delete(@PathVariable String username){
        userService.delete(username);
        return ResponseEntity.ok("User successfully deleted");
    }


}
