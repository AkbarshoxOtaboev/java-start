package com.example.javastart.api;

import com.example.javastart.entities.UserProfile;
import com.example.javastart.services.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user/profile")
@RequiredArgsConstructor
public class UserProfileApi {

    private final UserProfileService userProfileService;

    @PostMapping("/{username}/save")
    public ResponseEntity<String> saveUserProfile(@RequestBody UserProfile userProfile, @PathVariable String username){
        userProfileService.save(userProfile,username);
        return ResponseEntity.ok("Profile successfully saved");
    }

    @PutMapping("/{username}/update")
    public ResponseEntity<String> updateUserProfile(@RequestBody UserProfile userProfile, @PathVariable String username){
        userProfileService.update(userProfile, username);
        return ResponseEntity.ok("User profile successfully updated");
    }
}
