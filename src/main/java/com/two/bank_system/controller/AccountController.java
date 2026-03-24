package com.two.bank_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import com.two.bank_system.service.AccountService;


@RestController
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    private AccountService accountService;

    // GET - '/accounts'
    @GetMapping
    public String getAccountByEmail(@RequestParam String userEmail) {
        return accountService.getAccountByEmail(userEmail);
    }

    // POST - '/accounts'
    @PostMapping
    public String createAccount(String name, Integer cpf, String userEmail) {
        return accountService.createAccount(name, cpf, userEmail);
    }
}
