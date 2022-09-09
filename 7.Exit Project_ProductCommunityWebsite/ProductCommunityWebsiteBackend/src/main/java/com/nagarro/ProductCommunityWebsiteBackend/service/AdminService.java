package com.nagarro.ProductCommunityWebsiteBackend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nagarro.ProductCommunityWebsiteBackend.model.Admin;

/**
 * Service Interface for Admin.
 */
@Service
public interface AdminService {

	/**
	 * this method is to get list of admins from database.
	 * 
	 */
	public List<Admin> getAllAdmins();

	/**
	 * this method is to add a particular admin in database.
	 * 
	 * @param admin - admin which is to be added
	 * @return response after adding a particular admin to database.
	 */
	public Admin addAdmin(Admin admin);

	/**
	 * this method is to get a particular admin
	 * 
	 * @param username - username of admin
	 * @param password - password of admin
	 * @return a particular admin of associated with provided username and password
	 */
	public Admin getAdminByUserNameAndPassword(String username, String password);

}
