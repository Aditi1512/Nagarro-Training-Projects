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

import com.nagarro.LibraryManagementBackend.model.Author;
import com.nagarro.LibraryManagementBackend.service.AuthorService;

/**
 * This Author Controller class is responsible for processing incoming REST API
 * requests, preparing a model, and returning the view to be rendered as a
 * response.
 *
 */

@RestController
@RequestMapping("/api/author")
public class AuthorController {

	@Autowired
	private AuthorService authorService;

	/**
	 * this method is to build get all the authors REST API
	 */
	@GetMapping
	public List<Author> getBookList() {

		return authorService.getAuthors();
	}

	/**
	 * this method is to build get an author by id REST API
	 *
	 * @param id - id of author
	 * @return response body of list of author
	 */
	@GetMapping("{id}")
	public ResponseEntity<Author> getBook(@PathVariable("id") int id) {

		return new ResponseEntity<Author>(authorService.getAuthor(id), HttpStatus.OK);
	}

	/**
	 * this method is to build add an author REST API
	 * 
	 * @param author - Author of books
	 * @return response after adding author to database
	 */
	@PostMapping
	public ResponseEntity<Author> addBook(@RequestBody Author author) {

		return new ResponseEntity<Author>(authorService.addAuthor(author), HttpStatus.CREATED);
	}

	/**
	 * this method is to build edit an author REST API
	 * 
	 * @param id     - id of author
	 * @param author - author of book
	 * @return response after editing the author name and id
	 */
	@PutMapping("{id}")
	public ResponseEntity<Author> editBook(@PathVariable("id") int id, @RequestBody Author author) {

		return new ResponseEntity<Author>(authorService.editAuthor(author, id), HttpStatus.OK);
	}

	/**
	 * this method is to build delete an author REST API
	 * 
	 * @param id - id of author
	 * @return response after deleting the author of the provided id
	 */
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteBook(@PathVariable("id") int id) {

		authorService.deleteAuthor(id);
		return new ResponseEntity<String>("Author Deleted", HttpStatus.OK);

	}

}