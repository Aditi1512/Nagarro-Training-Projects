package com.nagarro.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nagarro.hibernateUtils.HibernateUtils;

/**
 * This class is to delete information of a user's product from database.
 * Servlet implementation class ProductDelete
 */

public class ProductDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductDelete() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * This class is to delete information of a user's product from database.
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String imageId = request.getParameter("id");
		int id = Integer.valueOf(imageId);
		HibernateUtils.deleteProductData(id);
		response.sendRedirect("Product.jsp");
	}

}
