package com.nagarro.LibraryManagementBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.LibraryManagementBackend.model.Author;

/**
 * This interface is a Author repository interface for performing CRUD operation
 * for Author
 *
 */
@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

}