
package com.two.bank_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.two.bank_system.domain.User;


public interface UserRepository extends JpaRepository<User, Long> {

      User findUserByEmail(String email);
}
