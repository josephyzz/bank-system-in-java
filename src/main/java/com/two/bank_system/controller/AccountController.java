package com.two.bank_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    @Autowired

    // GET - '/accounts'
    @GetMapping
    public String getAccount() {
        return "Test";
    }

    // POST - '/accounts'
    @PostMapping
    public String createAccount() {
        return "Test";
    }
}
