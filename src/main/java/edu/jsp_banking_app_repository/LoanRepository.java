package edu.jsp_banking_app_repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.jsp_banking_app_entity.Loan;


public interface LoanRepository extends JpaRepository<Loan ,Long>{
@Query(value = "select l from Loan l where l.user.uid = 1?")
Loan getLoanByUserId(long userId);

}