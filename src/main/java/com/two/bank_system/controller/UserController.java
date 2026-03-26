package com.two.bank_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import com.two.bank_system.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
  @Autowired
  private UserService userService;

  // GET - '/accounts'
  @GetMapping
  public String geUserByEmail(@RequestParam String email) {
    return userService.getUserByEmail(email);
  }

  // POST - '/accounts'
  @PostMapping
  public String createUser(String name, String email, String cpf) {
    return userService.createUser(name, email, cpf);
  }
}
