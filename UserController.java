package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Enities.User;
import com.example.demo.services.UserServices;

@RestController
@RequestMapping("/home")
public class UserController {
	
	@Autowired
	private UserServices services;
	
	@PostMapping("/user")
	public User addUser(@RequestBody User user) {
		return this.services.addUser(user);
		
	}
	
	@GetMapping("/alluser")
	public List<User> getUser(){
		return this.services.getUsers();
	}
    
	@PutMapping("/user/{userId}")
	public ResponseEntity<User> updateUserById(@PathVariable String userId,@RequestBody User user) {
	    this.services.updateUser(user,Long.parseLong(userId));
	    return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("/user/{userId}")
	public ResponseEntity<HttpStatus>deleteUser(@PathVariable String userId){
		try {
			this.services.deleteUser(Long.parseLong(userId));
			return new ResponseEntity<>(HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/user/{userId}")
	public Optional<User> getUserById(@PathVariable String userId) {
		
		return this.services.getUserById(Long.parseLong(userId));
	}
	
	
	
}
