package edu.jsp_banking_app_repository;

import java.util.Optional;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.jsp_banking_app_entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	//findByid(Long Id)
	boolean ExistsByEmail(String email);
	boolean ExistsByPhone(Long phone); 
	
	 Optional<User> findByEmail(String email);

}
