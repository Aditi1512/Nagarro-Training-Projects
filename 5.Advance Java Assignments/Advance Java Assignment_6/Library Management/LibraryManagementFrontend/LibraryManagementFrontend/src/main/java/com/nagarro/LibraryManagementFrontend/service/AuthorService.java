package com.nagarro.LibraryManagementFrontend.service;

import java.util.List;

import com.nagarro.LibraryManagementFrontend.model.Author;

/**
 * Service interface for author.
 *
 */
public interface AuthorService {

	/**
	 * This method is to return list of author.
	 * @return list of author.
	 */
	public List<Author> getAuthors();
}
