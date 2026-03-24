package com.two.bank_system.service;

import org.springframework.stereotype.Service;

import com.two.bank_system.repository.UserRepository;
import com.two.bank_system.domain.User;

@Service
public class UserService {
    private final UserRepository userRepository;

    public String getUserByEmail(String email) {
        User user = userRepository.findUserByEmail(email);
        return "Your User";
    }
    public String createUser(String name, String email, Integer cpf)
    {
        User user = (cpf != null && !cpf.isEmpty()) ? new User(name, email, cpf) : new User(name, email);
        return "User Created: " + user.getName() + " with email: " + user.getEmail();
    }
    
    public String changeEmail(String name, String newEmail) {
        // user.setEmail(newEmail);
        return "Email changed for user: " + name + " to new email: " + newEmail;
    }
}
