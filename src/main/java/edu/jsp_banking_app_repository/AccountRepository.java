package edu.jsp_banking_app_repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.jsp_banking_app_entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

}