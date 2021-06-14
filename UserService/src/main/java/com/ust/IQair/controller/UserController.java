package com.ust.IQair.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ust.IQair.exception.UserNotFoundException;
import com.ust.IQair.model.User;
import com.ust.IQair.service.UserService;
import io.swagger.annotations.Api;

@RestController
@Api
public class UserController {

	
	@Autowired
	UserService srvc;

	public UserController(UserService service) {
		this.srvc = service;
	}

	@PutMapping("/IQair/user/{id}")
	public ResponseEntity<?> update(@PathVariable() String id, @RequestBody User user) {
		try {
			return new ResponseEntity<User>(srvc.updateUser(id, user), HttpStatus.OK);
		} catch (UserNotFoundException exception) {
			return new ResponseEntity<String>(exception.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/IQair/user/{id}")
	public ResponseEntity<String> delete(@PathVariable() String id) {
		try {
			srvc.deleteUser(id);
			return new ResponseEntity<String>("Deleted User with id: " + id, HttpStatus.OK);
		} catch (UserNotFoundException exception) {
			return new ResponseEntity<String>(exception.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/IQair/user/{id}")
	public ResponseEntity<?> getUserById(@PathVariable() String id) {
		try {
			return new ResponseEntity<User>(srvc.getUserById(id), HttpStatus.OK);
		} catch (UserNotFoundException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
}
