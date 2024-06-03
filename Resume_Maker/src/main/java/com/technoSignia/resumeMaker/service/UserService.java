package com.technoSignia.resumeMaker.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.technoSignia.resumeMaker.dao.UserDao;
import com.technoSignia.resumeMaker.dto.LoginDTO;
import com.technoSignia.resumeMaker.dto.UserDTO;
import com.technoSignia.resumeMaker.entity.User;
import com.technoSignia.resumeMaker.response.LoginResponse;

@Service
public class UserService {

	@Autowired
	UserDao userDao;

	public String addUserDetails(UserDTO userDTO) {
		 User user = new User(
				    userDTO.getId(),
			        userDTO.getName(),
			        userDTO.getContact(),
			        userDTO.getEmail(),
			        userDTO.getPassword()
			    );

		// Check if email already exists
		Optional<User> existingUser = userDao.findByEmail(userDTO.getEmail());
		if (existingUser.isPresent()) {
			return "Email already exits";
		} else {
				userDao.save(user);
				return "User details added successfully";
		}
	}

	// method to login user
	public LoginResponse loginUser(LoginDTO loginDTO) {
		return userDao.findByEmail(loginDTO.getEmail())
				.filter(user -> user.getPassword().equals(loginDTO.getPassword()))
				.flatMap(user -> userDao.findOneByEmailAndPassword(loginDTO.getEmail(), user.getPassword()))
				.map(user -> new LoginResponse("Login success", true))
				.orElse(new LoginResponse("Email or Password does not exists", false));
	}

}
