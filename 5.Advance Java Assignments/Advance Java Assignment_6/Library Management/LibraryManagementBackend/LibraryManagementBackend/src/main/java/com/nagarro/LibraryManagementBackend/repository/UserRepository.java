package com.nagarro.LibraryManagementBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nagarro.LibraryManagementBackend.model.User;

/**
 * This interface is a User Repository Interface for Performing CRUD operation
 * on User.
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, String> {

	@Query("from User where username = ?1 AND password = ?2")
	User findByUsernameByPassword(String username, String password);
}
