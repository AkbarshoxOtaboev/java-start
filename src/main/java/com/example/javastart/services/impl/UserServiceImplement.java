package com.example.javastart.services.impl;

import com.example.javastart.entities.User;
import com.example.javastart.exception.ResourceNotFoundException;
import com.example.javastart.repositories.UserRepository;
import com.example.javastart.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
        return userRepository.findUserByUsername(username).orElseThrow(()-> new ResourceNotFoundException("User not found"));

    }

    @Override
    public Page<User> fetchAllUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public User update(String username, User user) {
        User updUser = userRepository.findUserByUsername(username).orElseThrow(()-> new ResourceNotFoundException("User not found"));
        updUser.setUsername(user.getUsername());
        updUser.setPassword(user.getPassword());
        updUser.setFullName(user.getFullName());
        return userRepository.saveAndFlush(updUser);
    }

    @Override
    public void delete(String username) {
        User user = userRepository.findUserByUsername(username).orElseThrow(()->new ResourceNotFoundException("User not found"));
        userRepository.delete(user);
    }
}
