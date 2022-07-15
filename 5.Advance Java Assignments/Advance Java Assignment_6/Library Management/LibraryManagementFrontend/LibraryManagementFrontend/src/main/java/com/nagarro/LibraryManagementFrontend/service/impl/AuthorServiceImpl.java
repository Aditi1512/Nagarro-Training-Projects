package com.nagarro.LibraryManagementFrontend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nagarro.LibraryManagementFrontend.constant.ApiConstant;
import com.nagarro.LibraryManagementFrontend.model.Author;
import com.nagarro.LibraryManagementFrontend.service.AuthorService;

/**
 * This class is service implementation of AuthorService interface.
 *
 */
@Service
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	private RestTemplate restTemplate;

	/**
	 * this method is use to return list of author.
	 *
	 */
	@Override
	public List<Author> getAuthors() {

		@SuppressWarnings("unchecked")
		List<Author> listOfAuthors = (List<Author>) restTemplate.getForObject(ApiConstant.AUTHOR_URL, List.class);
		return listOfAuthors;

	}

}
