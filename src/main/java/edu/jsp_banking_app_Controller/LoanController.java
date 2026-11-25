package edu.jsp_banking_app_Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.jsp_banking_app_Service.LoanService;
import edu.jsp_banking_app_entity.Loan;

@RestController
@RequestMapping("/api/loan")
public class LoanController {

	@Autowired
	private LoanService loanservice;

	@PostMapping("/{userId}")
	public ResponseEntity<Loan> applyLoan(@PathVariable Long userId, @RequestBody Loan l) {
		return new ResponseEntity<Loan>(loanservice.applyLoan(userId, l), HttpStatus.CREATED);

	}

	@GetMapping("/{id}")
	public ResponseEntity<Loan> getLoanById(@PathVariable long id) {
		return new ResponseEntity<Loan>(loanservice.getLoanById(id), HttpStatus.OK);
	}

	@DeleteMapping("/user/{userId}/loan/{loanId}")
	public ResponseEntity<String> deleteLoanById(@PathVariable Long userId, @PathVariable Long loanId) {

		return new ResponseEntity<>(loanservice.deleteLoanById(userId, loanId), HttpStatus.OK);
	}


	@GetMapping("/user/{userId}")
	public ResponseEntity<Loan> getLoanByUserId(@PathVariable Long userId) {
		return new ResponseEntity<Loan>(loanservice.getLoanByUserId(userId), HttpStatus.OK);
	}

	@GetMapping("/status/{loanId}")
	public ResponseEntity<String> getLoanStatus(@PathVariable long loanId) {
		return new ResponseEntity<String>(loanservice.getLoanStatus(loanId), HttpStatus.OK);
	}

}