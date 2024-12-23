package com.ecom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.dto.UserReqDto;
import com.ecom.service.UserService;

import jakarta.validation.Valid;
import lombok.val;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	public UserController() {
		System.out.println("Inside userController");
	}
	
	@PostMapping
	ResponseEntity<?> addUser(@RequestBody UserReqDto  userReqDto){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.addNewUser(userReqDto));
	}
		
	
}
