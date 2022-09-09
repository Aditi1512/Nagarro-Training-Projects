package com.nagarro.ProductCommunityWebsiteBackend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.ProductCommunityWebsiteBackend.model.Admin;
import com.nagarro.ProductCommunityWebsiteBackend.repository.AdminRepository;
import com.nagarro.ProductCommunityWebsiteBackend.service.AdminService;

/**
 * This class is service implementation Admin service interface.
 *
 */
@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminRepository;

	/**
	 * this method is to get list of admins from database
	 */
	@Override
	public List<Admin> getAllAdmins() {
		// TODO Auto-generated method stub
		return adminRepository.findAll();
	}

	/**
	 * this method is to add a particular admin to database
	 */
	@Override
	public Admin addAdmin(Admin admin) {
		return adminRepository.save(admin);
	}

	/**
	 * this method is to return a particular admin from database associated with
	 * provided username and password
	 */
	@Override
	public Admin getAdminByUserNameAndPassword(String username, String password) {
		return adminRepository.findByUsernameByPassword(username, password);
	}

}
