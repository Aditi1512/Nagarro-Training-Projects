package com.nagarro.serviceImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import com.nagarro.dao.UserDao;
import com.nagarro.model.User;

/**
 * This class is to save user's information into database and check if user is
 * already registered or not.
 *
 */
public class UserServiceImpl {

	@Autowired
	private UserDao userdao;

	/**
	 * This method returns true or false after checking if user name and password
	 * exist in database or not.
	 * 
	 * @param username - user name of user
	 * @param password - password of user
	 * @return - true or false after checking if user name and password exist in
	 *         database or not.
	 */
	public boolean validateUser(String username, String password) {

		User user = userdao.getUser(username);

		return user != null && user.getPassword().equals(password);
	}

	/**
	 * This method returns true or false after checking if user is already
	 * registered or not.
	 * 
	 * @param userName - user name of user
	 * @return true or false after checking if user is already registered or not.
	 */
	public boolean isRegisteredUser(String userName) {
		String username = userName;
		boolean isValid = false;

		User user = userdao.registeredUser(username);

		if (user != null) {
			isValid = false;
		} else {
			isValid = true;

		}

		return isValid;
	}

	/**
	 * This method save user information into database.
	 * 
	 * @param username - user name of user
	 * @param fullname - full name of user
	 * @param password - password of user
	 * @param email    - email address of user
	 */
	public void saveUser(String username, String fullname, String password, String email) {

		User user = new User();
		user.setEmail(email);
		user.setFullname(fullname);
		user.setPassword(password);
		user.setUsername(username);
		userdao.saveUser(user);

	}

}