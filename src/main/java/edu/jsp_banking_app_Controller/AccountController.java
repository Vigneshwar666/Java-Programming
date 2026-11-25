
package edu.jsp_banking_app_Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.jsp_banking_app_Service.AccountService;
import edu.jsp_banking_app_entity.Account;

@RestController
@RequestMapping("/api/account")
public class AccountController {

  @Autowired
  private AccountService accountService;
  
  @PostMapping("{userId}")
  public ResponseEntity<Account> createAccount(@PathVariable Long userId, @RequestBody Account  account){
    return new ResponseEntity<Account>(accountService.createAccount(userId , account), HttpStatus.CREATED);
    
  }
  @GetMapping("/{a_id}")
  public ResponseEntity<Account> getAccountById(@PathVariable Long a_id){
    return new ResponseEntity<Account>(accountService.getAccountById(a_id), HttpStatus.OK);
  }
  @GetMapping("/user/{userId}/Account/{a_id}")
    public ResponseEntity<String> deleteLoanById(@PathVariable Long userId , @PathVariable Long a_id){
      
    
  return new ResponseEntity<String>(accountService.deleteAccountById(userId, a_id), HttpStatus.OK);
  
  }
  @GetMapping("user/{userId}")
  public ResponseEntity<Account> getLoanById(@PathVariable Long userID){
    return new ResponseEntity<Account>(accountService.getAccountById(userID),HttpStatus.OK);
  }
  
  
  
  
}
