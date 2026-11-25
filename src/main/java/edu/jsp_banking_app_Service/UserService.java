package edu.jsp_banking_app_Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.jsp_banking_app_entity.User;
import edu.jsp_banking_app_repository.UserRepository;

public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User saveUser(User user) {

		boolean isEmailPresent = userRepository.ExistsByEmail(user.getEmail());
		boolean isPhonePresent = userRepository.ExistsByPhone(user.getPhone());

		if (isEmailPresent) {
			throw new ResourcesAlreadyExistsException(user.getEmail());
		}

		if (isPhonePresent) {
			throw new ResourcesAlreadyExistsException(String.valueOf(user.getPhone()));
		}
		return userRepository.save(user);

	}

	public User getUserById(long id) {
		return userRepository.findById(id).orElseThrow(() -> new ResourcesNotFoundException("User", "id", id));

	}

	public List<User> getAll() {
		return userRepository.findAll();
		
	}

	public String deleteUserById(long id) {
		User u = userRepository.findById(id).orElseThrow(() -> new ResourcesNotFoundException("user", "id", id));
		userRepository.delete(u);
		return "Data Deleted!!!";
	}

	public User getUserByEmail(String email) {
		return userRepository.findByEmail(email)
				.orElseThrow(() -> new ResourcesNotFoundException("user", "email", email));
	}


}
