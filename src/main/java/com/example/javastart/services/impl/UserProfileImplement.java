package com.example.javastart.services.impl;

import com.example.javastart.entities.User;
import com.example.javastart.entities.UserProfile;
import com.example.javastart.repositories.UserProfileRepository;
import com.example.javastart.services.UserProfileService;
import com.example.javastart.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserProfileImplement implements UserProfileService {

    private final UserProfileRepository userProfileRepository;
    private final UserService userService;
    @Override
    public void save(UserProfile userProfile, String username) {
        User user = userService.fetchUserByUsername(username);
        user.setUserProfile(userProfile);
        userService.save(user);
    }

    @Override
    public void update(UserProfile userProfile, String username) {
        User user = userService.fetchUserByUsername(username);
        UserProfile updUserProfile = user.getUserProfile();
        updUserProfile.setProfilePhoto(userProfile.getProfilePhoto());
        updUserProfile.setAddress(userProfile.getAddress());
        updUserProfile.setPhone(userProfile.getPhone());
        user.setUserProfile(updUserProfile);
        userService.update(username, user);
    }
}
