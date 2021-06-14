package com.ust.IQair.service;

import com.ust.IQair.exception.UserNotFoundException;
import com.ust.IQair.model.User;

public interface UserService {

	User updateUser(String userId, User user) throws UserNotFoundException;

	boolean deleteUser(String userId) throws UserNotFoundException;

	User getUserById(String userId) throws UserNotFoundException;

}
