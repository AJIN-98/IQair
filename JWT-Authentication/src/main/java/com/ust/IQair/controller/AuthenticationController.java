package com.ust.IQair.controller;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ust.IQair.model.User;
import com.ust.IQair.exception.UserNotFoundException;
import com.ust.IQair.service.UserAuthenticationImplement;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.swagger.annotations.Api;


@RestController
@Api
public class AuthenticationController {

	@Autowired
	UserAuthenticationImplement implement;
	

	public AuthenticationController(UserAuthenticationImplement authicationService) {
		this.implement = authicationService;
	}
	
	@PostMapping("/IQair/register")
	public ResponseEntity<String> register(@RequestBody User user) {
		try {
			
			if(!implement.saveUser(user)) {
				throw new Exception();
			}
			return new ResponseEntity<String>("Registered", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
		}

	}

	@PostMapping("/IQair/login")
	public ResponseEntity<String> login(@RequestBody User user) {
		try {
			implement.findByUserIdAndPassword(user.getUserId(), user.getUserPassword());
			return new ResponseEntity<String>(getToken(user, user.getUserId(), user.getUserPassword()), HttpStatus.OK);
		} catch (UserNotFoundException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.UNAUTHORIZED);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.UNAUTHORIZED);
		}
	}

	public String getToken(@RequestBody User user, String userId, String userPassword) throws Exception {
		return Jwts.builder().setId(userId).setSubject(userPassword).setIssuedAt(new Date()).signWith(SignatureAlgorithm.HS256, "secretkey").compact();

	}

}
