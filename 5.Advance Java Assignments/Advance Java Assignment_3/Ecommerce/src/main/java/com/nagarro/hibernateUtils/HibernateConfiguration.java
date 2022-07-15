package com.nagarro.hibernateUtils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nagarro.model.Product;
import com.nagarro.model.User;


/**
 * This class is use to configure hibernate session.
 *
 */
public class HibernateConfiguration {
	/**
	 * This method creates and opens a session.
	 * 
	 * @return a session to get a connection to database.
	 */
	public static Session getSession() {

		@SuppressWarnings("deprecation")
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class)
				.addAnnotatedClass(Product.class).buildSessionFactory();
		Session session = factory.openSession();

		return session;
	}

}
