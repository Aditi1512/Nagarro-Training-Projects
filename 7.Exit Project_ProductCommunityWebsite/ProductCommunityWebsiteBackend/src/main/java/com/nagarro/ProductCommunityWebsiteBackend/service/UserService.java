package com.nagarro.ProductCommunityWebsiteBackend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nagarro.ProductCommunityWebsiteBackend.model.User;

/**
 * Service Interface for Admin.
 */
@Service
public interface UserService {

	/**
	 * this method is to get list of all users present in database.
	 * 
	 * @return list of users.
	 */
	public List<User> getAllUsers();

	/**
	 * this method is to add a particular user in database.
	 * 
	 * @param user - user which is to be added.
	 * @return response after adding a particular user to database.
	 */
	public User addUser(User user);

	/**
	 * this method is to get a particular user associated with provided username and
	 * password.
	 * 
	 * @param user - user which is to be fetched
	 * @return user associated with provided username and password.
	 */
	public User getUserByUserNameAndPassword(String username, String password);

}
