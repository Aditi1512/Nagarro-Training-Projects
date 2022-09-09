package com.nagarro.ProductCommunityWebsiteBackend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.ProductCommunityWebsiteBackend.model.User;
import com.nagarro.ProductCommunityWebsiteBackend.repository.UserRepository;
import com.nagarro.ProductCommunityWebsiteBackend.service.UserService;

/**
 * This class is service implementation User service interface.
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	/**
	 * this method is to return list of user present in database.
	 */
	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	/**
	 * this method is to add user in database.
	 */
	@Override
	public User addUser(User user) {
		return userRepository.save(user);
	}

	/**
	 * this method is to return user associated with provided username and password
	 * present in database.
	 */
	@Override
	public User getUserByUserNameAndPassword(String username, String password) {
		return userRepository.findByUsernameByPassword(username, password);
	}

}
