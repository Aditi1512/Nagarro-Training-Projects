package com.nagarro.TshirtSearchProgram.hibernateUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nagarro.TshirtSearchProgram.model.Tshirt;

/**
 * 
 * This class use to configure hibernate session.
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
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Tshirt.class)
				.buildSessionFactory();
		Session session = factory.openSession();

		return session;
	}
}
