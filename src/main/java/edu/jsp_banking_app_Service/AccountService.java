package edu.jsp_banking_app_Service;


import org.springframework.beans.factory.annotation.Autowired;

import edu.jsp_banking_app_entity.Account;
import edu.jsp_banking_app_entity.User;
import edu.jsp_banking_app_repository.AccountRepository;
import edu.jsp_banking_app_repository.UserRepository;

public class AccountService {

  @Autowired
  private UserRepository userRepository;
  @Autowired
  private AccountRepository accountRepository;
  
  public Account createAccount(Long userId ,Account account ) {
    User u = userRepository.findById(userId).orElseThrow(() -> new ResourcesNotFoundException("User", "User Id", userId));
    u.addAccount(account);
    return accountRepository.save(account);
  }
  public Account getAccountById(long a_id) {
    return  accountRepository.findById(a_id).orElseThrow(()-> new ResourcesNotFoundException("Account", "account Id", a_id));
  }
  public String deleteAccountById(Long userId, long a_id) {
    User user = userRepository.findById(userId).orElseThrow( () -> new ResourcesNotFoundException("user", "user id", userId));
    Account a = accountRepository.findById(a_id).orElseThrow(()-> new ResourcesNotFoundException("Account", "account Id", a_id));
    
    user.removeAccount(a);
    userRepository.save(user);
    return "Loan data Deleted";

    
  }
  
}