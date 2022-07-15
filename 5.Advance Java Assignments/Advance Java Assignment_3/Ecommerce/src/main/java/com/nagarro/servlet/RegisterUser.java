package com.nagarro.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.nagarro.hibernateUtils.HibernateUtils;
import com.nagarro.model.User;

/**
 * This class is use to register user in database. Servlet implementation class
 * RegisterUser
 */
@WebServlet("/register")
public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * THis is use to Redirect to login page
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
		rd.forward(request, response);
	}

	/**
	 * This method is to register user and save the information in database only if
	 * user is not registered before.
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String fullName = request.getParameter("fullName");
		String userName = request.getParameter("userName");
		String email = request.getParameter("emailId");
		String password = request.getParameter("password");

		PrintWriter out = response.getWriter();

		User addUser = new User(fullName, userName, email, password);

		User user = HibernateUtils.registerUser(userName);

		if (user != null) {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('The user is already Registered. Please Login.');");
			out.println("window.location = \"/Ecommerce/Login.jsp\";");
			out.println("</script>");
			return;
		} else {
			HibernateUtils.addUser(addUser);

		}
		response.getWriter().print("User Registered sucessfully");
		RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
		rd.forward(request, response);

	}

}
