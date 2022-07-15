package com.nagarro.LibraryManagementBackend.service;

import java.util.List;

import com.nagarro.LibraryManagementBackend.model.Author;

/**
 * Service Interface for Author.
 *
 */
public interface AuthorService {

	/**
	 * this method is get list of all authors.
	 * 
	 * @return list of authors
	 */
	public List<Author> getAuthors();

	/**
	 * this method is to get a particular authors
	 * 
	 * @param id - id of the author which is to be returned
	 * @return a particular author
	 */
	public Author getAuthor(int id);

	/**
	 * this method is to add particular author
	 * 
	 * @param author - author e=which is to be added
	 * @return added author
	 */
	public Author addAuthor(Author author);

	/**
	 * this method is to edit the author
	 * 
	 * @param author - edit a particular author
	 * @param id     - id of author which is to be edited
	 * @return edited author
	 */
	public Author editAuthor(Author author, int id);

	/**
	 * this method is to delete the author
	 * 
	 * @param id - id of the author which is to be deleted
	 */
	public void deleteAuthor(int id);

}