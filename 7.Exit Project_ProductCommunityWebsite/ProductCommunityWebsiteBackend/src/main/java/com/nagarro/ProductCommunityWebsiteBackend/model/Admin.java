package com.nagarro.ProductCommunityWebsiteBackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * This is the model class for Admin that contains attribute associated with a
 * Admin.
 */
@Entity
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int adminId;
	String fullname;
	@Column(unique = true)
	String username;
	String password;
	String email;

	public Admin() {
		super();
	}

	public Admin(String fullname, String username, String password, String email) {
		super();
		this.fullname = fullname;
		this.username = username;
		this.password = password;
		this.email = email;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setUserId(int userId) {
		this.adminId = userId;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", fullname=" + fullname + ", username=" + username + ", password="
				+ password + ", email=" + email + "]";
	}

}