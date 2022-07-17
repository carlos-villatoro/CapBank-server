package com.capbank.CapBank.controllers;


import com.capbank.CapBank.models.Account;
import com.capbank.CapBank.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    public AccountRepository accountRepository;

    @GetMapping()
    public List<Account> getAllAccounts(){
        return accountRepository.findAll();
    }

    @PostMapping("/create")
    public String createAccount(@RequestBody Account account){
        Account insertedAccount = accountRepository.insert(account);
        return "Account created" + insertedAccount.getAccountNumber();
    }
}
