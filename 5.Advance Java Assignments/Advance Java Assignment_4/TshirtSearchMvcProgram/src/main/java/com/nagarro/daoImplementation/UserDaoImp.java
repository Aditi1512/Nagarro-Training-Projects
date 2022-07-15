package com.nagarro.daoImplementation;

import org.hibernate.Query;
import org.hibernate.Session;

import com.nagarro.configuration.HibernateConfiguration;
import com.nagarro.constants.HqlQueries;
import com.nagarro.dao.UserDao;
import com.nagarro.model.User;

/**
 * This class is used to handle user's authentication.
 *
 */
public class UserDaoImp implements UserDao {

	/**
	 * This method is use to save user's data into database.
	 *
	 */
	public void saveUser(User user) {
		// TODO Auto-generated method stub

		Session session = HibernateConfiguration.getSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();

	}

	/**
	 * This method is use to get information of user's who is logged in.
	 *
	 */
	public User getUser(String username) {
		// TODO Auto-generated method stub

		Session session = HibernateConfiguration.getSession();
		session.beginTransaction();

		Query query = session.createQuery(HqlQueries.QUERY_USER);
		query.setParameter("username", username);
		User user = (User) query.uniqueResult();
		session.getTransaction().commit();
		session.close();

		return user;
	}

	/**
	 * This method is to register user.
	 *
	 */
	public User registeredUser(String userName) {
		Session session = HibernateConfiguration.getSession();
		session.beginTransaction();
		Query query = session.createQuery(HqlQueries.QUERY_USER);
		query.setParameter("username", userName);
		User user = (User) query.uniqueResult();

		return user;
	}
}