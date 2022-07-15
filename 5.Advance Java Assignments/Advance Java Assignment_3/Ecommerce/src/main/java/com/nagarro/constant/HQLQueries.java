package com.nagarro.constant;

/**
 * his class store the constant HQL query.
 *
 */
public class HQLQueries {

	public static final String SAVE_PRODUCT_QUERY = "from User where userName=:username";
	public static final String EDIT_PRODUCT_QUERY = "from Product where id = :imageId";
	public static final String DELETE_PRODUCT_QUERY = "delete from Product where id = :imageId";
	public static final String LOGIN_USER_QUERY = "from User where userName = :username";
	public static final String FORGOT_PASSWORD_QUERY = "from User where username=:username and emailAddress=:email";
	public static final String RESET_PASSWORD_QUERY = "from User where userName= :username";
	public static final String REGISTER_USER_QUERY = "from User where userName = :username";

}
