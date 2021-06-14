package com.ust.IQair.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.IQair.exception.UserNotFoundException;
import com.ust.IQair.model.User;
import com.ust.IQair.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository reposit;

	public User updateUser(String userId, User user) throws UserNotFoundException {
		try {
			reposit.save(user);
			return reposit.findById(userId).get();
		} catch (NoSuchElementException e) {
			throw new UserNotFoundException("Oops! User not found");
		}

	}

	public boolean deleteUser(String userId) throws UserNotFoundException {
		boolean status = false;
		try {
			User userfound = reposit.findById(userId).get();
			if (userfound != null) 
			{
				reposit.delete(userfound);
				status = true;
			}
		} catch (NoSuchElementException exception) {
			throw new UserNotFoundException("User with ID: "+userId+",not found!");
		}
		return status;
	}

	public User getUserById(String userId) throws UserNotFoundException {
		try {
			return reposit.findById(userId).get();
		} catch (NoSuchElementException e) {
			throw new UserNotFoundException("User with ID:"+userId+",not found!");
		}
	}

}
