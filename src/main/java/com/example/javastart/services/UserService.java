package com.example.javastart.services;

import com.example.javastart.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {

    User save(User user);
    User fetchUserByUsername(String username);
    Page<User> fetchAllUsers(Pageable pageable);
    User update(String username, User user);

    void delete(String username);
}
