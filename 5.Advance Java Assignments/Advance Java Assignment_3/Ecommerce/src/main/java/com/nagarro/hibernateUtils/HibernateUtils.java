package com.nagarro.hibernateUtils;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;

import com.nagarro.constant.HQLQueries;
import com.nagarro.model.Product;
import com.nagarro.model.User;

/**
 * This class describe the usage of hibernate.
 *
 */
public class HibernateUtils {

	/**
	 * This method is used to save product in database
	 * 
	 * @param product  - object of products
	 * @param username - user name of a user who is currently logged in
	 * @param response - sending a response
	 * @throws ServletException - servlet exception
	 * @throws IOException      - input output exception
	 */
	public static void saveProductData(Product product, String username, HttpServletResponse response)
			throws ServletException, IOException {
		Session session = HibernateConfiguration.getSession();
		session.beginTransaction();

		Query query = session.createQuery(HQLQueries.SAVE_PRODUCT_QUERY);
		query.setParameter("username", username);

		PrintWriter out = response.getWriter();
		User user = (User) query.uniqueResult();
		user.getProductList().add(product);
		try {
			session.save(user);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Image could not be saved.Image size greater than 1 MB!!');");
			out.println("window.location = \"/Ecommerce/Product.jsp\";");
			out.println("</script>");
			return;
		}

		session.close();
	}

	/**
	 * This method is to edit product's data
	 * 
	 * @param id        - id of user whose product is to be edit
	 * @param title     - title of product
	 * @param quantity  - quantity of product
	 * @param size      - size of product
	 * @param bFile     - image of product in bytes
	 * @param imageName - name of product image
	 * @param response  - sending a response
	 * @throws ServletException - servlet exception
	 * @throws IOException      - input output exception
	 */
	public static void editProductData(int id, String title, String quantity, String size, byte[] bFile,
			String imageName, HttpServletResponse response) throws ServletException, IOException {
		Session session = HibernateConfiguration.getSession();
		session.beginTransaction();

		Query query = session.createQuery(HQLQueries.EDIT_PRODUCT_QUERY);
		query.setParameter("imageId", id);
		Product product = (Product) query.uniqueResult();
		PrintWriter out = response.getWriter();
		product.setTitle(title);
		product.setQuantity(quantity);
		product.setSize(size);
		product.setImage(bFile);
		product.setImgName(imageName);
		try {
			session.update(product);
			session.getTransaction().commit();
		} catch (Exception e) {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Image could not be saved.Image size greater than 1 MB!!');");
			out.println("</script>");

		}
		session.close();
	}

	/**
	 * This method is used delete information of user from database
	 * 
	 * @param id - id of user who's information is to be deleted from database.
	 */
	public static void deleteProductData(int id) {
		Session session = HibernateConfiguration.getSession();
		session.beginTransaction();

		Query query = session.createQuery(HQLQueries.DELETE_PRODUCT_QUERY);
		query.setParameter("imageId", id).executeUpdate();
		try {
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static User loginUser(String username) {
		Session session = HibernateConfiguration.getSession();
		session.beginTransaction();

		Query query = session.createQuery(HQLQueries.LOGIN_USER_QUERY);
		query.setParameter("username", username);

		User user = (User) query.uniqueResult();
		session.getTransaction().commit();
		session.close();

		return user;
	}

	/**
	 * @param userName - user name of user who is logged in.
	 * @return information of user to be registered.
	 */
	public static User registerUser(String userName) {

		Session session = HibernateConfiguration.getSession();
		session.beginTransaction();
		Query query = session.createQuery(HQLQueries.REGISTER_USER_QUERY);
		query.setParameter("username", userName);
		User user = (User) query.uniqueResult();

		return user;
	}

	/**
	 * This method is to add information of user who is to registered .
	 * 
	 * @param addUser - user to be registered
	 */
	public static void addUser(User addUser) {

		Session session = HibernateConfiguration.getSession();
		session.beginTransaction();
		try {
			session.saveOrUpdate(addUser);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			session.close();

			e.printStackTrace();
		}
	}

	/**
	 * This method is to take user name and email id of user whose password is to
	 * reset and to check whether user is registered or not
	 * 
	 * @param username - user name of user who is logged in.
	 * @param email    - email Id of user who is logged in.
	 * @return - object of user.
	 */
	public static User forgotPassword(String username, String email) {

		Session session = HibernateConfiguration.getSession();
		session.beginTransaction();
		Query query = session.createQuery(HQLQueries.FORGOT_PASSWORD_QUERY);
		query.setParameter("username", username);
		query.setParameter("email", email);
		User user = (User) query.uniqueResult();
		session.getTransaction().commit();
		session.close();

		return user;
	}

	/**
	 * This method is to reset user's password
	 * 
	 * @param username      - user name of user who is logged in
	 * @param resetPassword - password to reset
	 */
	public static void resetPassword(String username, String resetPassword) {
		Session session = HibernateConfiguration.getSession();
		session.beginTransaction();

		Query query = session.createQuery(HQLQueries.RESET_PASSWORD_QUERY);
		query.setParameter("username", username);
		User user = (User) query.uniqueResult();
		user.setPassword(resetPassword);

		try {
			session.update(user);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();

		}

		session.close();
	}
}
