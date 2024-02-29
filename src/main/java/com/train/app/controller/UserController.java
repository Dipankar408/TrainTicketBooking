package com.train.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.train.app.entity.User;
import com.train.app.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping
	public ResponseEntity<User> addUser(@RequestBody User user){
		return new ResponseEntity<>(userService.addUser(user),HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getUser(@PathVariable Long id){
		return new ResponseEntity<>(userService.getUser(id), HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<User> updateUser(@RequestBody User user){
		return new ResponseEntity<>(userService.updateUser(user), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Long id){
		return new ResponseEntity<>(userService.deleteUser(id), HttpStatus.OK);
	}
}
