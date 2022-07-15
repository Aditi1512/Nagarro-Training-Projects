package com.nagarro.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.Query;
import org.hibernate.Session;

import com.nagarro.hibernateUtils.HibernateConfiguration;

/**
 * This class is a model class of User.
 *
 */
@Entity
public class User {

	@Id
	@GeneratedValue
	@Column(name = "Id")
	int id;

	@Column(name = "FullName")
	String fullName;

	@Column(name = "UserName", unique = true)
	String userName;

	@Column(name = "EmailAddress")
	String emailAddress;

	@Column(name = "Password")
	String password;

	@OneToMany(targetEntity = Product.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	List<Product> productList;

	public User() {
	}

	public User(String fullName, String userName, String emailAddress, String password) {
		super();
		this.fullName = fullName;
		this.userName = userName;
		this.emailAddress = emailAddress;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	public static List<Product> getProductList(String name) {

		Session session = HibernateConfiguration.getSession();
		session.beginTransaction();
		Query query = session.createQuery("from User where Username = :param");
		query.setParameter("param", name);
		User u = (User) query.uniqueResult();
		List<Product> li;
		try {
			li = u.getProductList();
		} catch (Exception e) {
			li = null;
		}
		session.getTransaction().commit();
		session.close();
		return li;
	}
}
