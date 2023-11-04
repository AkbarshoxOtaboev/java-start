package com.example.javastart.services;

import com.example.javastart.entities.User;

import java.util.List;

public interface UserService {

    User save(User user);
    User fetchUserByUsername(String username);
    List<User> fetchAllUsers();
    User update(String username, User user);

    void delete(String username);
}
