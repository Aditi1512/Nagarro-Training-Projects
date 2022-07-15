package com.nagarro.LibraryManagementBackend.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.LibraryManagementBackend.exception.ResourceNotFoundException;
import com.nagarro.LibraryManagementBackend.model.Book;
import com.nagarro.LibraryManagementBackend.model.User;
import com.nagarro.LibraryManagementBackend.repository.BookRepository;
import com.nagarro.LibraryManagementBackend.repository.UserRepository;
import com.nagarro.LibraryManagementBackend.service.BookService;

/**
 * This class is service implementation Book service interface.
 *
 */
@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

//	@Autowired
//	private UserRepository userRepository;
	public List<Book> list;

	/**
	 * this method is get list of all books
	 */
	@Override
	public List<Book> getBooks() {
		// TODO Auto-generated method stub
		return bookRepository.findAll();
	}

	/**
	 * this method is get a particular book
	 */
	@Override
	public Book getBook(long bookCode) {

		return bookRepository.findById(bookCode)
				.orElseThrow(() -> new ResourceNotFoundException("Book", "bookCode", bookCode));
	}

	/**
	 * this method is add a particular book
	 */
	@Override
	public Book addBook(Book book) {

//		Optional<User> user = userRepository.findById(book.getUserName());
//		book.setUser(user.get());
		bookRepository.save(book);
		return book;
	}

	/**
	 * this method is edit a particular book
	 */
	@Override
	public Book editBook(Book book, long bookCode) {

		Book existingBook = bookRepository.findById(bookCode)
				.orElseThrow(() -> new ResourceNotFoundException("Book", "bookCode", bookCode));
		existingBook.setAuthor(book.getAuthor());
		existingBook.setName(book.getName());

		bookRepository.save(existingBook);
		return existingBook;
	}

	/**
	 * this method is delete a particular book
	 */
	@Override
	public void deleteBook(long bookCode) {
		bookRepository.findById(bookCode)
				.orElseThrow(() -> new ResourceNotFoundException("Book", "bookCode", bookCode));
		bookRepository.deleteById(bookCode);

	}

}
