package com.two.bank_system.service;

import org.springframework.stereotype.Service;

import com.two.bank_system.repository.UserRepository;
import com.two.bank_system.domain.User;

@Service
public class UserService {
  private final UserRepository userRepository;

  // Dependency Injection, entrega um repo pronto para uso.
  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public User getUserByEmail(String email) {
    return userRepository.findByEmail(email)
        .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
  }

  public String createUser(String name, String email, String cpf) {
    User user;
    if (cpf == null) {
      user = new User(name, email);
    } else {
      user = new User(name, email, cpf);
    }
    return "User Created: " + user.getName() + " with email: " + user.getEmail();
  }
}
