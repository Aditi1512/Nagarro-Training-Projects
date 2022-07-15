package com.nagarro.LibraryManagementBackend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.LibraryManagementBackend.exception.ResourceNotFoundException;
import com.nagarro.LibraryManagementBackend.model.Author;
import com.nagarro.LibraryManagementBackend.repository.AuthorRepository;
import com.nagarro.LibraryManagementBackend.service.AuthorService;

/**
 * This class is service implementation Author service interface.
 *
 */
@Service
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	private AuthorRepository authorRepository;
	public List<Author> list;

	/**
	 * this method is get list of all authors.
	 */
	@Override
	public List<Author> getAuthors() {
		return authorRepository.findAll();
	}

	/**
	 * this method is to get a particular authors
	 */
	@Override
	public Author getAuthor(int id) {

		return authorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Author", "id", id));
	}

	/**
	 * this method is to add particular author
	 */
	@Override
	public Author addAuthor(Author author) {

		authorRepository.save(author);
		return author;
	}

	/**
	 * this method is to edit the author
	 */
	@Override
	public Author editAuthor(Author author, int id) {

		Author existingAuthor = authorRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Author", "Id", id));
		existingAuthor.setAuthorName(author.getAuthorName());

		authorRepository.save(existingAuthor);
		return existingAuthor;
	}

	/**
	 * this method is to delete the author
	 */
	@Override
	public void deleteAuthor(int id) {
		authorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Author", "Id", id));
		authorRepository.deleteById(id);

	}

}