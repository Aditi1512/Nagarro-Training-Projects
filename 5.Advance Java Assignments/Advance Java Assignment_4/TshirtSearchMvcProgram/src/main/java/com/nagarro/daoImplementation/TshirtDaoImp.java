package com.nagarro.daoImplementation;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.nagarro.configuration.HibernateConfiguration;
import com.nagarro.constants.Constants;
import com.nagarro.constants.HqlQueries;
import com.nagarro.dao.TshirtDao;
import com.nagarro.model.Tshirt;

/**
 * This class use to save t-shirt data into database and fetch data for user's
 * search request.
 *
 */
public class TshirtDaoImp implements TshirtDao {

	/**
	 * This method is use to save t-shirt data into database.
	 */
	public void saveData(List<Tshirt> tshirtList) {
		// TODO Auto-generated method stub
		Session session = HibernateConfiguration.getSession();
		session.beginTransaction();
		try {
			for (Tshirt tshirtData : tshirtList) {
				session.saveOrUpdate(tshirtData);
			}

			session.getTransaction().commit();

		} catch (HibernateException e) {
			session.getTransaction().rollback();
		}
		session.close();

	}

	/**
	 * This method is use to fetch data for user's search request.
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<Tshirt> getData(String color, String size, String gender, String outputPreference) {

		List<Tshirt> sortedTshirtList = new ArrayList<>();
		String hqlQuery;
		Session session = HibernateConfiguration.getSession();
		session.beginTransaction();

		if (outputPreference.equalsIgnoreCase(Constants.RATING)) {
			hqlQuery = HqlQueries.QUERY_ORDERBY_RATING;
		}

		else if (outputPreference.equalsIgnoreCase(Constants.PRICE)) {
			hqlQuery = HqlQueries.QUERY_ORDERBY_PRICE;
		}

		else {
			hqlQuery = HqlQueries.QUERY_ORDERBY_BOTH;
		}

		Query query = session.createQuery(hqlQuery);
		query.setParameter("color", color);
		query.setParameter("size", size);
		query.setParameter("gender", gender);
		sortedTshirtList = query.list();
		session.getTransaction().commit();
		session.close();

		return sortedTshirtList;

	}
}