package com.example.demo.service;

import com.example.demo.entity.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    public ResponseEntity<String> createUser(User user);

    public List<User> getAllUsers();
}
