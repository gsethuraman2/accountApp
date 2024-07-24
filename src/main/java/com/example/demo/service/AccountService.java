package com.example.demo.service;

import com.example.demo.entity.Account;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AccountService {
    public List<Account> getAllAccounts();

    public ResponseEntity<String> createAccount(Account account,Long userId);
}
