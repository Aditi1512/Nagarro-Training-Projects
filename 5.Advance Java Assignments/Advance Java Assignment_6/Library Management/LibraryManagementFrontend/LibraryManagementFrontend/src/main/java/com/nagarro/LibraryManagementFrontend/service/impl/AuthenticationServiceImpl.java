package com.nagarro.LibraryManagementFrontend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nagarro.LibraryManagementFrontend.constant.ApiConstant;
import com.nagarro.LibraryManagementFrontend.model.User;
import com.nagarro.LibraryManagementFrontend.service.AuthenticationService;

/**
 * This class is service implementation of AuthenticationService interface.
 *
 */
@Service
public class AuthenticationServiceImpl implements AuthenticationService {

	@Autowired
	private RestTemplate restTemplate;

	/**
	 * this method is use to get user.
	 */
	@Override
	public User getUserByUsernameAndPassword(String username, String password) {
		ResponseEntity<String> response = restTemplate.getForEntity(ApiConstant.USER_URL + username + "/" + password,
				String.class);
		HttpStatus statusCode = response.getStatusCode();
		HttpHeaders responseHeader = response.getHeaders();
		String responseBody = response.getBody();
		System.out.println(statusCode + responseBody + responseHeader);
		User user = restTemplate.getForObject(ApiConstant.USER_URL + username + "/" + password, User.class);
		return user;

	}

	/**
	 * this method is use to add user into database.
	 */
	@Override
	public void addUser(User user) {
		ResponseEntity<String> response = restTemplate.postForEntity(ApiConstant.USER_URL, user, String.class);
		HttpStatus statusCode = response.getStatusCode();
		HttpHeaders responseHeader = response.getHeaders();
		String responseBody = response.getBody();
		System.out.println(statusCode + responseBody + responseHeader);
	}

}
