package com.example.demo.controller;

import com.example.demo.custom.UserOnly;
import com.example.demo.entity.User;
import com.example.demo.entity.UserAuthDto;
import com.example.demo.service.UserService;
import com.example.demo.serviceImpl.JwtService;
import com.example.demo.serviceImpl.MyUserDetailsService;
import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin("http://localhost:4200")
@CrossOrigin(origins = {"http://localhost:4200","http://localhost:3000"})
@RestController
@RequestMapping("/user")
@UserOnly
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping

    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/authenticate")
    public String authenticateAndGetToken(@RequestBody UserAuthDto userAuthDto){

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userAuthDto.getUsername(),userAuthDto.getPassword()
                ));

        if(authentication.isAuthenticated()){
            return jwtService.generateToken(userDetailsService.loadUserByUsername(userAuthDto.getUsername()));
        } else {
            throw new UsernameNotFoundException("Invalid credentials");
        }
    }
}
