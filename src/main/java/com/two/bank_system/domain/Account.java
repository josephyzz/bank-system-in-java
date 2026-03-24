package com.two.bank_system.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString // Para retorna o objeto em formato de texto
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // campo único para o JPA identificar 

    private String name;
    private Integer cpf;
    private double balance;
    private Integer accountNumber;
    private String userEmail;

    // construtor customizado
    public Account(String name, Integer cpf, String userEmail) {
        this.name = name;
        this.cpf = cpf;
        this.balance = 0.0;
        this.accountNumber = (int) (Math.random() * 1000000);
        this.userEmail = userEmail;
    }
}
