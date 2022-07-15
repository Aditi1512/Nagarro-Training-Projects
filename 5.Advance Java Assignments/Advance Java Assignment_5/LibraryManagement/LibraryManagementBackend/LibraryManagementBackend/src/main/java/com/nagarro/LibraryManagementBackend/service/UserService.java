package com.nagarro.LibraryManagementBackend.service;

import java.util.List;

import com.nagarro.LibraryManagementBackend.model.User;

/**
 * Service interface for User.
 *
 */
public interface UserService {

	/**
	 * this method returns list of all users
	 * 
	 * @return list of user
	 */
	public List<User> getUsers();

	/**
	 * this method is to add user to current session
	 * 
	 * @param user - user which is to be added
	 * @return user
	 */
	public User addUser(User user);

	/**
	 * this method is used to return current user
	 * 
	 * @param username - username of user
	 * @param password - password of user
	 * @return current user
	 */
	public User getUser(String username, String password);
}