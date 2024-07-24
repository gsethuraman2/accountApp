package com.example.demo.serviceImpl;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> user =  userRepository.findByUsername(username);

        if(user.isPresent()){
            User loggingUser = user.get();

            return org.springframework.security.core.userdetails.User.builder()
                    .username(loggingUser.getUsername())
                    .password(loggingUser.getPassword())
                    .roles(loggingUser.getRole())
                    .build();

        } else {
            throw new UsernameNotFoundException("User not found");
        }
    }
}
