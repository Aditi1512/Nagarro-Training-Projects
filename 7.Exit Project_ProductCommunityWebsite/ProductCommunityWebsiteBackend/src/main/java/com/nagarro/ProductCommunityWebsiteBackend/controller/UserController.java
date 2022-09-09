package com.nagarro.ProductCommunityWebsiteBackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.ProductCommunityWebsiteBackend.model.User;
import com.nagarro.ProductCommunityWebsiteBackend.service.UserService;

/**
 * This User Controller class is responsible for processing incoming REST API
 * requests, preparing a model, and returning the view to be rendered as a
 * response.
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/user/")
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * this method is to build add user REST API
	 * 
	 * @param user - user that has to be added
	 * @return response after adding user in the database
	 * @throws Exception
	 */
	@PostMapping
	public ResponseEntity<User> addUser(@RequestBody User user) throws Exception {

		User userExist = userService.getUserByUserNameAndPassword(user.getUsername(), user.getPassword());
		if (userExist != null) {
			throw new Exception("User already exists");
		} else {
			return new ResponseEntity<User>(userService.addUser(user), HttpStatus.CREATED);
		}

	}

	/**
	 * this method is to return list all users present in database
	 * 
	 * @return list of all users
	 */
	@GetMapping
	public List<User> getAllUsers() {

		return userService.getAllUsers();

	}

	/**
	 * this method is to get total number of users
	 *
	 */
	@GetMapping("/totalUsers")
	public int getTotalNumberOfAdmins() {

		int totalUsersCount;
		if (userService.getAllUsers().isEmpty()) {
			totalUsersCount = 0;
		} else {
			totalUsersCount = userService.getAllUsers().size();
		}

		return totalUsersCount;
	}
}
