package com.nagarro.constants;

/**
 * 
 * This class store the constant SQL query.
 * 
 */
public class HqlQueries {

	public static final String QUERY_ORDERBY_RATING = "from Tshirt where Color = :color AND Size= :size AND Gender = :gender order by rating DESC";
	public static final String QUERY_ORDERBY_PRICE = "from Tshirt where Color = :color AND Size= :size AND Gender = :gender order by price ASC";
	public static final String QUERY_ORDERBY_BOTH = "from Tshirt where Color = :color AND Size= :size AND Gender = :gender order by price, rating DESC";
	public static final String QUERY_USER = "from User where username=:username";

}