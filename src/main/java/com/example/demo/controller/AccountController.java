package com.example.demo.controller;

import com.example.demo.entity.Account;
import com.example.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// frontend in react and angular the server 3000 and 4200
// 8080

@CrossOrigin("*")
@RestController
@RequestMapping("/account")
public class AccountController {
    // accountController
    @Autowired
    private AccountService service;

    @GetMapping
    public List<Account> getAllAccounts(){
        return service.getAllAccounts();
    }

    @PostMapping("/{userId}")
    public ResponseEntity<String> createAccount(@RequestBody Account account, @PathVariable Long userId){
        return service.createAccount(account,userId);
    }
}
