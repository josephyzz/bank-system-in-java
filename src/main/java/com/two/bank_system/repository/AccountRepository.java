package com.two.bank_system.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.two.bank_system.domain.Account;


//Utilizei uuid, para que seja seguro para a conta do usuario
//no momento de visualizar a propria conta, pois apois a busca pelo id
//o Id ficará exposto no url da pagina. (não sei se estou certo)
public interface AccountRepository extends JpaRepository<Account, UUID> {

      Account findAccountByEmail(String userEmail);
}
