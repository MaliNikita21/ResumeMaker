package com.technoSignia.resumeMaker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.technoSignia.resumeMaker.dao.UserDao;
import com.technoSignia.resumeMaker.dto.LoginDTO;
import com.technoSignia.resumeMaker.dto.UserDTO;
import com.technoSignia.resumeMaker.entity.User;

@Service
public class UserService {

	@Autowired
	UserDao userDao;
	
	@Autowired
	PasswordEncoder passwordEncoder;

	public User addUserDetails(UserDTO userDTO) {
		User user=new User(
	    	userDTO.getId(),	
			userDTO.getName(),
			userDTO.getContact_No(),
			userDTO.getEmail_Id(),
			userDTO.getPassword(),
	    	userDTO.getConfirm_Password()
			);
		return userDao.save(user);
	}

	public String loginUser(LoginDTO loginDTO) {
				return null;
	}
}
