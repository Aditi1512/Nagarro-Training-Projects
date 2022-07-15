package com.nagarro.LibraryManagementBackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.LibraryManagementBackend.model.Book;
import com.nagarro.LibraryManagementBackend.service.BookService;

/**
 * This Book Controller class is responsible for processing incoming REST API
 * requests, preparing a model, and returning the view to be rendered as a
 * response.
 *
 */
@RestController
@RequestMapping("/api/book")
public class BookController {

	@Autowired
	private BookService bookService;

	/**
	 * this method is to build get all the book REST API
	 * 
	 * @return list of books
	 */
	@GetMapping
	public List<Book> getBookList() {

		return this.bookService.getBooks();
	}

	/**
	 * this method is to build get particular book REST API
	 * 
	 * @param bookCode - code of the book that is to be return
	 * @return response body of book asked by user
	 */
	@GetMapping("{bookCode}")
	public ResponseEntity<Book> getBooks(@PathVariable("bookCode") long bookCode) {

		return new ResponseEntity<Book>(bookService.getBook(bookCode), HttpStatus.OK);
	}

	/**
	 * this method is to build add books REST API
	 * 
	 * @param book - the book to be added
	 * @return response after adding the book
	 */
	@PostMapping
	public ResponseEntity<Book> addBook(@RequestBody Book book) {

		return new ResponseEntity<Book>(bookService.addBook(book), HttpStatus.CREATED);
	}

	/**
	 * this method is to build edit books REST API
	 * 
	 * @param book - book which is to be edited
	 * @return response after editing the book
	 */
	@PutMapping("{bookCode}")
	public ResponseEntity<Book> editBook(@PathVariable("bookCode") long bookCode, @RequestBody Book book) {

		return new ResponseEntity<Book>(bookService.editBook(book, bookCode), HttpStatus.OK);
	}

	/**
	 * this method is to delete edit books REST API
	 * 
	 * @param bookCode - code of the book which is to be deleted
	 * @return response after deleting the book
	 */
	// build delete a book REST API
	@DeleteMapping("{bookCode}")
	public ResponseEntity<String> deleteBook(@PathVariable("bookCode") long bookCode) {

		bookService.deleteBook(bookCode);
		return new ResponseEntity<String>("Book Deleted", HttpStatus.OK);

	}

}
