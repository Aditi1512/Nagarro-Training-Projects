package com.nagarro.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nagarro.hibernateUtils.HibernateUtils;
import com.nagarro.model.User;

/**
 * This is use to reset user's password. Servlet implementation class
 * ForgotPassword
 */
public class ForgotPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ForgotPassword() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * This servlet is use to change password for user if user exist.
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String email = request.getParameter("email");

		PrintWriter out = response.getWriter();

		User user = HibernateUtils.forgotPassword(username, email);

		if (user == null) {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Username or Email does not match!');");
			out.println("window.location = \"/Ecommerce/ForgotPassword.jsp\";");
			out.println("</script>");
			return;
		} else {

			response.addCookie(new Cookie("username", username));
			response.sendRedirect("ResetPassword.jsp");
		}

	}

}