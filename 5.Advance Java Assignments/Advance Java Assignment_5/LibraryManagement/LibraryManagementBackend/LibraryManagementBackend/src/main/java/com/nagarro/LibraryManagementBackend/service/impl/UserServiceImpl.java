package com.nagarro.LibraryManagementBackend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nagarro.LibraryManagementBackend.model.User;
import com.nagarro.LibraryManagementBackend.repository.UserRepository;
import com.nagarro.LibraryManagementBackend.service.UserService;

/**
 * This class is service implementation Book service interface.
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	/**
	 * this method returns list of all users
	 */
	@Override
	public List<User> getUsers() {

		return userRepository.findAll();
	}

	/**
	 * this method is to add user to current session
	 */
	@Override
	public User addUser(User user) {
		userRepository.save(user);
		return user;
	}

	/**
	 * this method is used to return current user
	 */
	@Override
	public User getUser(String username, String password) {
		User result = userRepository.findByUsernameByPassword(username, password);
		if (result == null) {
			result = null;
		}
		return result;

	}

}