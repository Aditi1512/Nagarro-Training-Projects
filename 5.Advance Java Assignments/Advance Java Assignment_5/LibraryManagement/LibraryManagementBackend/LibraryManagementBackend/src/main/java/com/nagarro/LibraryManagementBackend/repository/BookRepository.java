package com.nagarro.LibraryManagementBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.LibraryManagementBackend.model.Book;

/**
 * This interface is a Book Repository interface for performing CRUD operation
 * on Book.
 *
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
