
package edu.jsp_banking_app_Service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.jsp_banking_app_entity.Loan;
import edu.jsp_banking_app_entity.User;
import edu.jsp_banking_app_repository.LoanRepository;
import edu.jsp_banking_app_repository.UserRepository;

@Service
public class LoanService {

	@Autowired
	private LoanRepository loanRepository;

	@Autowired
	private UserRepository userRepository;

	// Apply for a loan
	public Loan applyLoan(Long userId, Loan loan) {

		User user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourcesNotFoundException("user", "user id", userId));

		loan.setApply(LocalDateTime.now());
		user.addLoan(loan);

		return loanRepository.save(loan);
	}

	// Get loan by loan ID
	public Loan getLoanById(long id) {

		return loanRepository.findById(id).orElseThrow(() -> new ResourcesNotFoundException("Loan", "loan id", id));
	}

	// Delete loan by user ID and loan ID
	@Transactional
	public String deleteLoanById(Long userId, Long loanId) {

		User user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourcesNotFoundException("user", "user id", userId));

		Loan loan = loanRepository.findById(loanId)
				.orElseThrow(() -> new ResourcesNotFoundException("Loan", "loan id", loanId));

		if (loan.getUser() == null || loan.getUser().getUid() != userId.longValue()) {
			throw new ResourcesNotFoundException("Loan", "loan id", loanId);
		}

		user.removeLoan(loan);
		loanRepository.delete(loan);

		return "Loan data deleted successfully";
	}

	// Get loan by user ID
	public Loan getLoanByUserId(Long userId) {
		return loanRepository.getLoanByUserId(userId);
	}

	// Get loan status by loan ID
	public String getLoanStatus(long loanId) {

		Loan loan = loanRepository.findById(loanId)
				.orElseThrow(() -> new ResourcesNotFoundException("Loan", "loan id", loanId));

		return loan.getStatus();
	}
}
