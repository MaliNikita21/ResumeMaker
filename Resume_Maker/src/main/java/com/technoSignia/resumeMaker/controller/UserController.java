package com.technoSignia.resumeMaker.controller;

import org.springframework.web.bind.annotation.RestController;

import com.technoSignia.resumeMaker.dto.LoginDTO;
import com.technoSignia.resumeMaker.dto.UserDTO;
import com.technoSignia.resumeMaker.response.LoginResponse;
import com.technoSignia.resumeMaker.service.UserService;

import jakarta.validation.Valid;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
//@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<Object> saveUserDetails( @Valid @RequestBody UserDTO userDTO, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			
			List<String> errors = bindingResult.getAllErrors().stream().map(error -> error.getDefaultMessage())
					.collect(Collectors.toList());
			return ResponseEntity.badRequest().body(errors);
		}
		String saveUserDetails= userService.addUserDetails(userDTO);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(saveUserDetails);
	}

//	//API for user registration
//	@PostMapping("/register")
//	public String saveUserDetails(@RequestBody UserDTO userDTO) {	
//		return userService.addUserDetails(userDTO);
//	}

	//API for user login
	@PostMapping("/login")
	public LoginResponse loginUser(@RequestBody LoginDTO loginDTO) {
		return userService.loginUser(loginDTO);
	}
	
}
