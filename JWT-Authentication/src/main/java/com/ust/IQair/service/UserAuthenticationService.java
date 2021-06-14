package com.ust.IQair.service;


import org.springframework.stereotype.Repository;

import com.ust.IQair.exception.UserAlreadyExistsException;
import com.ust.IQair.exception.UserNotFoundException;
import com.ust.IQair.model.User;


@Repository
public interface UserAuthenticationService {
	
	 public User findByUserIdAndPassword(String userId, String userPassword) throws UserNotFoundException;

	 boolean saveUser(User user) throws UserAlreadyExistsException;
}
