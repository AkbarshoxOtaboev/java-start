package com.example.javastart.services;

import com.example.javastart.entities.UserProfile;

public interface UserProfileService {
    void save(UserProfile userProfile, String username);

    void update(UserProfile userProfile, String username);


}
