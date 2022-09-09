package com.nagarro.ProductCommunityWebsiteBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nagarro.ProductCommunityWebsiteBackend.model.*;

/**
 * This interface is a Admin repository interface for performing CRUD operation
 * on data associated with Admin table.
 */
@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

	/**
	 * query to fetch an admin associated with provided username and password
	 */
	@Query("from Admin where username = ?1 AND password = ?2")
	Admin findByUsernameByPassword(String username, String password);
}
