package com.ust.IQair.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ust.IQair.exception.UserAlreadyExistsException;
import com.ust.IQair.exception.UserNotFoundException;
import com.ust.IQair.model.User;
import com.ust.IQair.repository.UserAuthenticationRepository;

@Service
public class UserAuthenticationImplement implements UserAuthenticationService{
	
	@Autowired
	UserAuthenticationRepository repo;
	
	public UserAuthenticationImplement(UserAuthenticationRepository repo) {
		this.repo = repo;
	}

	@Override
	public User findByUserIdAndPassword(String userId, String userPassword) throws UserNotFoundException {
		User user=repo.findByUserIdAndUserPassword(userId, userPassword);
		if(user ==null) {
			throw new UserNotFoundException("User is not found");
		}
		return user;
	}

	@Override
	public boolean saveUser(User user) throws UserAlreadyExistsException {
		if(repo.findById(user.getUserId()).isPresent()){
			throw new UserAlreadyExistsException("User already exist");
		}
		repo.save(user);
		return true;
	}

}
