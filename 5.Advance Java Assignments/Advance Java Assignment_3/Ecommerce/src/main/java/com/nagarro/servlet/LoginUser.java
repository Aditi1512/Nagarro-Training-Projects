package com.nagarro.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.nagarro.hibernateUtils.HibernateUtils;
import com.nagarro.model.User;

/**
 * This is use to login user. Servlet implementation class LoginUser
 */
@WebServlet("/login")
public class LoginUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * This method is use for login user into an account.
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String username = request.getParameter("userName");
		String password = request.getParameter("password");

		PrintWriter out = response.getWriter();
		User user = HibernateUtils.loginUser(username);

		if (user == null) {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('User does not exist. Please Register.');");
			out.println("window.location = \"/Ecommerce/Register.jsp\";");
			out.println("</script>");
			return;
		}

		else if (user.getPassword().equals(password)) {
			response.getWriter().print("Login Successfull");
			response.addCookie(new Cookie("username", username));
			response.addCookie(new Cookie("password", password));
			response.sendRedirect("Product.jsp");
		}

		else {

			out.println("<script type=\"text/javascript\">");
			out.println("alert('You entered the wrong password');");
			out.println("window.location = \"/Ecommerce/Login.jsp\";");
			out.println("</script>");
			return;
		}
	}

}
