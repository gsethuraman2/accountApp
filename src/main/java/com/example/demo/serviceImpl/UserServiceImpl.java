package com.example.demo.serviceImpl;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import com.example.demo.utility.AccountUtilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public ResponseEntity<String> createUser(User user) {

        User newUser = new User();

        newUser.setName(user.getName());
        newUser.setPhoneNumber(user.getPhoneNumber());


        newUser.setPassword(passwordEncoder.encode(user.getPassword()));


        newUser.setUsername(user.getUsername());
        newUser.setRole("USER");

        userRepository.save(newUser);

        return ResponseEntity.ok(AccountUtilities.USER_CREATED_SUCCESS.getMessage());
    }// "User has been registered successfully."

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
