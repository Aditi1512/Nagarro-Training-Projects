package com.nagarro.LibraryManagementFrontend.service;

import java.util.List;

import com.nagarro.LibraryManagementFrontend.model.Book;

/**
 * Service Interface for Author.
 *
 */
/**
 * @author aditijha
 *
 */
/**
 * @author aditijha
 *
 */
public interface BookService {

	/**
	 * this method is get a particular book
	 * 
	 * @param bookCode - code of the book which is to fetched.
	 * @return the particular book.
	 */
	public Book getBook(long bookCode);

	/**
	 * this method is get list of all books
	 * 
	 * @return list of all books
	 */
	public List<Book> getBooks();

	/**
	 * this method is add a particular book
	 * 
	 * @param book - book which is to be added
	 */
	public void addBook(Book book);

	/**
	 * this method is edit a particular book.
	 * 
	 * @param book - book which is to be edited
	 */
	public void editBook(Book book);

	/**
	 * this method is delete a particular book
	 * 
	 * @param bookCode - book which is to be deleted
	 */
	public void deleteBook(long bookCode);

}
