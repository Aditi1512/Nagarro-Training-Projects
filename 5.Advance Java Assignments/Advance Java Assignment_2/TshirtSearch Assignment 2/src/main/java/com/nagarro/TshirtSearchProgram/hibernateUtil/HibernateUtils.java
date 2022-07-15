package com.nagarro.TshirtSearchProgram.hibernateUtil;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import com.nagarro.TshirtSearchProgram.constant.Constant;
import com.nagarro.TshirtSearchProgram.constant.SQLQueries;
import com.nagarro.TshirtSearchProgram.model.Tshirt;

/**
 * 
 * This class describe the usage of hibernate.
 * 
 */
public class HibernateUtils {

	/**
	 * This method save CSV file data into table.
	 * 
	 * @param tshirtList- the list that stores CSV File data.
	 */
	public static void saveData(List<Tshirt> tshirtList) {
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
	 * Compare the user input with database data and return sorted list of t-shirt
	 * that user want if available.
	 * 
	 * @param userInput the object that store user data
	 * @return a sorted list of t-shirt user want
	 */
	@SuppressWarnings("unchecked")
	public List<Tshirt> getData(Tshirt userInput) {

		List<Tshirt> sortedTshirtList = new ArrayList<>();

		String sql;

		Session session = HibernateConfiguration.getSession();
		session.beginTransaction();

		if (userInput.getOutputPreference().equalsIgnoreCase(Constant.RATING)) {
			sql = SQLQueries.SQL_QUERY_ORDER_BY_RATING;

		}

		else if (userInput.getOutputPreference().equalsIgnoreCase(Constant.PRICE)) {
			sql = SQLQueries.SQL_QUERY_ORDER_BY_PRICE;
		}

		else {
			sql = SQLQueries.SQL_QUERY_ORDER_BY_BOTH;
		}
		SQLQuery query = session.createSQLQuery(sql);
		query.addEntity(Tshirt.class);
		query.setParameter("color", userInput.getTshirtColor());
		query.setParameter("size", userInput.getTshirtSize());
		query.setParameter("gender", userInput.getGenderRecommendation());
		sortedTshirtList = query.list();
		session.getTransaction().commit();
		session.close();

		return sortedTshirtList;

	}
}
