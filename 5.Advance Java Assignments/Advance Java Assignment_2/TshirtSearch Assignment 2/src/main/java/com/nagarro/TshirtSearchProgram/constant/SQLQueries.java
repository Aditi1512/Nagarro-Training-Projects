package com.nagarro.TshirtSearchProgram.constant;

/**
 * 
 * This class store the constant SQL query.
 * 
 */
public class SQLQueries {

	public static final String SQL_QUERY_ORDER_BY_RATING = "SELECT * from Tshirt T where T.Color = :color AND T.Size= :size AND T.Gender = :gender order by rating DESC";
	public static final String SQL_QUERY_ORDER_BY_PRICE = "SELECT * from Tshirt T where T.Color = :color AND T.Size= :size AND T.Gender = :gender order by price ASC";
	public static final String SQL_QUERY_ORDER_BY_BOTH = "SELECT * from Tshirt T where T.Color = :color AND T.Size= :size AND T.Gender = :gender order by price, rating DESC";

}
