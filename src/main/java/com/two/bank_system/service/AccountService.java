package com.two.bank_system.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.two.bank_system.domain.Account;
import com.two.bank_system.repository.AccountRepository;

@Service
public class AccountService {

  private final AccountRepository accountRepository;

  // Dependency Injection, entrega um repo pronto para uso.
  public AccountService(AccountRepository accountRepository) {
    this.accountRepository = accountRepository;
  }

  public String getAccount() {
        return "Hello Accounts";
  }
  public String getAccountByEmail(@RequestParam String userEmail) {
    Account account = accountRepository.findAccountByEmail(userEmail);
    return "Your Account:\n" +
        "Number: " + account.getAccountNumber() + "\n" +
        "Name: " + account.getName() + "\n" +
        "CPF: " + account.getCpf() + "\n" +
        "Balance: " + account.getBalance() + "\n" +
        "Email: " + account.getUserEmail();
  }

  public String createAccount(@RequestParam String name, @RequestParam Integer cpf, @RequestParam String userEmail) {
    Account account = new Account(name, cpf, userEmail);
    return "Account Created: " + account.getName() + " with CPF: " + account.getCpf();
  }

  public String addBalance(@RequestParam Integer accountNumber, @RequestParam double amount) {
    // Alguma forma de encontrar a conta pelo número, tava pensando em usar um for
    // loop mas acredito que para um banco com muitos usuários isso seria muito
    // ineficiente, podemos dar uma olhada nisso quando você fizer o banco de dados.
    // account.setBalance(account.getBalance() + amount);
    // Veja o que fiz no metodo getAccountByEmail
    return "Balance added: " + amount + " to account number: " + accountNumber;
  }

  public String withdrawBalance(@RequestParam Integer accountNumber, @RequestParam double amount) {
    // account.setBalance(account.getBalance() - amount);
    return "Balance withdrawn: " + amount + " from account number: " + accountNumber;
  }

  public String transferBalance(@RequestParam Integer fromAccountNumber, @RequestParam Integer toAccountNumber,
      @RequestParam double amount) {
    // accountFrom.setBalance(accountFrom.getBalance() - amount);
    // accountTo.setBalance(accountTo.getBalance() + amount);
    return "Balance transferred: " + amount + " from account number: " + fromAccountNumber + " to account number: "
        + toAccountNumber;
  }
}
