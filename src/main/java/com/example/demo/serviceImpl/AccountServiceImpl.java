package com.example.demo.serviceImpl;

import com.example.demo.entity.Account;
import com.example.demo.entity.AccountId;
import com.example.demo.entity.User;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.AccountService;
import com.example.demo.utility.AccountUtilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
   // accountService

    @Autowired
    private AccountRepository accountRepository;
    // accountRepository

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public ResponseEntity<String> createAccount(Account account,Long userId) {
    // access specifier  returnType methodName(parameters )

        BigInteger threshold = BigInteger.valueOf(10000);

        Optional<User> holdingUser = userRepository.findById(userId);

        // UserId - User from database, initially no accounts are there for user
        // holdingUser.isPresent() - true
        // holdingUser = null
        // holdingUser.isPresent() - false
        if(holdingUser.isPresent()){

            User updatedUser = holdingUser.get();
            // name , phone, id, empty hashset
            Account newAccount = new Account();

            newAccount.setAccountName(account.getAccountName());
            newAccount.setAccountHolderName(account.getAccountHolderName());
            newAccount.setAadhar(account.getAadhar());
            newAccount.setCreatedTimestamp(LocalDateTime.now());

            newAccount.setUser(updatedUser);
//            accountRepository.save(newAccount);
            // accounts.add(newAccount);
            updatedUser.getAccounts().add(newAccount); // updating the user with the account
//            userRepository.save(updatedUser);

            if(account.getInitialAmount().compareTo(threshold)>0){
                accountRepository.save(newAccount);

                userRepository.save(updatedUser); // updating the user

                // hashset with account
                return ResponseEntity.ok(AccountUtilities.ACCOUNT_CREATED_SUCCESS.getMessage());
            } else{
                return ResponseEntity.ok(AccountUtilities.ACCOUNT_CREATED_FAILURE.getMessage());
            }
        }

        return ResponseEntity.ok(AccountUtilities.USER_NOT_FOUND.getMessage());


    }
}
