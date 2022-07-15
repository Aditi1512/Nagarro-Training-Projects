package com.nagarro.LibraryManagementBackend.service;

import java.util.List;

import com.nagarro.LibraryManagementBackend.model.Book;

/**
 * Service Interface for Book.
 *
 */
public interface BookService {

	/**
	 * this method is get list of all books
	 * 
	 * @return list of all books
	 */
	public List<Book> getBooks();

	/**
	 * this method is get a particular book
	 * 
	 * @param bookCode - code of the book which is to fetched.
	 * @return the particular book.
	 */
	public Book getBook(long bookCode);

	/**
	 * this method is add a particular book
	 * 
	 * @param book - book which is to be added
	 * @return added book
	 */
	public Book addBook(Book book);

	/**
	 * this method is edit a particular book
	 * 
	 * @param book     - book which is to be edited
	 * @param bookCode - code of the edited book
	 * @return edited book
	 */
	public Book editBook(Book book, long bookCode);

	/**
	 * this method is delete a particular book
	 * 
	 * @param bookCode - code of the book which is to be deleted.
	 */
	public void deleteBook(long bookCode);

}
