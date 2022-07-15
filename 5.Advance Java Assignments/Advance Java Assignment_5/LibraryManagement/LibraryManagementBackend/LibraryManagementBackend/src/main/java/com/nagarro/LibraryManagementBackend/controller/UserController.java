package com.nagarro.LibraryManagementBackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.nagarro.LibraryManagementBackend.model.User;
import com.nagarro.LibraryManagementBackend.service.UserService;

/**
 * UserController class is responsible for processing incoming REST API
 * requests, preparing a model, and returning the view to be rendered as a
 * response.
 *
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * this method is to build add a user REST ABookPI
	 * 
	 * @param user - user which is to be added
	 * @return response after adding user
	 */
	@PostMapping
	public ResponseEntity<User> addUser(@RequestBody User user) {

		return new ResponseEntity<User>(userService.addUser(user), HttpStatus.CREATED);
	}

	/**
	 * This method returns list of all books
	 * 
	 * @return list of all books
	 */
	@GetMapping
	public List<User> getAllUsers() {

		return userService.getUsers();
	}

	/**
	 * this method is to build get user by username and password REST API
	 * 
	 * @param username - username of user
	 * @param password - password of user
	 * @return response after getting user
	 */
	@GetMapping("{username}/{password}")
	public ResponseEntity<User> getUser(@PathVariable("username") String username,
			@PathVariable("password") String password) {

		return new ResponseEntity<User>(userService.getUser(username, password), HttpStatus.OK);
	}

}