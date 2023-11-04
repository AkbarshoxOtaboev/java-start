package com.example.javastart.services.impl;

import com.example.javastart.entities.User;
import com.example.javastart.repositories.UserRepository;
import com.example.javastart.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImplement implements UserService {
    private final UserRepository userRepository;
    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User fetchUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    @Override
    public List<User> fetchAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User update(String username, User user) {
        User updUser = userRepository.findUserByUsername(username);
        updUser.setUsername(user.getUsername());
        updUser.setPassword(user.getPassword());
        updUser.setFullName(user.getFullName());
        return userRepository.saveAndFlush(updUser);
    }

    @Override
    public void delete(String username) {
        User user = userRepository.findUserByUsername(username);
        userRepository.delete(user);
    }
}
