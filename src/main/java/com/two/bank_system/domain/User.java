package com.two.bank_system.domain;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Gera o ID
    private Long id; // campo único para o JPA identificar
    private String name;
    private String email;
    private String cpf;

    
    // construtor customizado
    public User(String name, String email, String cpf) {
      this.name = name;
      this.cpf = cpf;
      this.email = email;
    }

    //Sobrecarga
    public User(String name, String email) {
      this.name = name;
      this.email = email;
    }

}
