package com.technoSignia.resumeMaker.controller;

import org.springframework.web.bind.annotation.RestController;

import com.technoSignia.resumeMaker.dto.LoginDTO;
import com.technoSignia.resumeMaker.dto.UserDTO;
import com.technoSignia.resumeMaker.entity.User;
import com.technoSignia.resumeMaker.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
//@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping(path = "/save")
	public User saveUserDetails(@RequestBody UserDTO userDTO) {
		System.out.println("data extracted" + userDTO);
		return userService.addUserDetails(userDTO);
	}

	@PostMapping(path = "/login")
	public String loginUser(@RequestBody LoginDTO loginDTO) {
          return userService.loginUser(loginDTO);
	}

}
