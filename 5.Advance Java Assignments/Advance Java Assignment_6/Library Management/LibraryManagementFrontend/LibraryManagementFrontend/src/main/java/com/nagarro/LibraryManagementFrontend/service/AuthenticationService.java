package com.nagarro.LibraryManagementFrontend.service;

import com.nagarro.LibraryManagementFrontend.model.User;

/**
 * Service interface for User Authentication.
 *
 */
public interface AuthenticationService {

	/**
	 * this method is use to add user into database.
	 * 
	 * @param user - user to add into database
	 */
	public void addUser(User user);

	/**
	 * this method is use to return user.
	 * 
	 * @param username - user name of user
	 * @param password - password of user
	 * @return user
	 */
	public User getUserByUsernameAndPassword(String username, String password);

}
