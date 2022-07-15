package com.nagarro.LibraryManagementFrontend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nagarro.LibraryManagementFrontend.constant.ApiConstant;
import com.nagarro.LibraryManagementFrontend.model.Book;
import com.nagarro.LibraryManagementFrontend.service.BookService;

/**
 * This class is service implementation of BookService interface.
 *
 */
@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private RestTemplate restTemplate;

	/**
	 * this method is to get a particular book of provided book code.
	 *
	 */
	@Override
	public Book getBook(long bookCode) {
		Book book = restTemplate.getForObject(ApiConstant.BOOK_URL + bookCode, Book.class);
		return book;
	}

	/**
	 * this method is to get a list of book.
	 */
	@Override
	public List<Book> getBooks() {
		@SuppressWarnings("unchecked")
		List<Book> listOfBooks = (List<Book>) restTemplate.getForObject(ApiConstant.BOOK_URL, List.class);
		return listOfBooks;
	}

	/**
	 * this method is add a book into database.
	 */
	@Override
	public void addBook(Book book) {
		restTemplate.postForEntity(ApiConstant.BOOK_URL, book, Book.class);

	}

	/**
	 * this method is to edit a book details of provided book code.
	 */
	@Override
	public void editBook(Book book) {
		restTemplate.put(ApiConstant.BOOK_URL + book.getCode(), book, Book.class);

	}

	/**
	 * this method is to delete book from database.
	 */
	@Override
	public void deleteBook(long bookCode) {
		restTemplate.delete(ApiConstant.BOOK_URL + bookCode, Book.class);

	}

}
