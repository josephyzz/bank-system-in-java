package com.two.bank_system.domain;

import com.two.bank_system.domain.User;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Account {
    private String name;
    private Integer cpf;
    private double balance;
    private Integer accountNumber;
    private String userEmail;

    public Account(String name, Integer cpf, String userEmail) {
        this.name = name;
        this.cpf = cpf;
        this.balance = 0.0;
        this.accountNumber = (int) (Math.random() * 1000000);
        this.userEmail = userEmail;
    }
}
