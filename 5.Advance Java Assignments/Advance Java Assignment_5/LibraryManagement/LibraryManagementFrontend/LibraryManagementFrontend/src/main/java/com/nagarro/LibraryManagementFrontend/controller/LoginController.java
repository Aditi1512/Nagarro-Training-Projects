package com.nagarro.LibraryManagementFrontend.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nagarro.LibraryManagementFrontend.model.Author;
import com.nagarro.LibraryManagementFrontend.model.User;
import com.nagarro.LibraryManagementFrontend.service.AuthenticationService;
import com.nagarro.LibraryManagementFrontend.service.AuthorService;

/**
 * This Login Controller class handle all login request for a web applications.
 *
 */
@Controller

public class LoginController {

	@Autowired
	private AuthenticationService authService;

	@Autowired
	private AuthorService authorService;

	/**
	 * this method is use to open login page
	 * 
	 * @return login page
	 */
	@RequestMapping("login")
	public String loginPage() {
		return "login";
	}

	/**
	 * this method is use to login user into the current session and check if user
	 * already exist or credentials are valid.
	 * 
	 * @param username - name of user
	 * @param password - password of user
	 * @param model    - contains user details
	 * @param session  - current session
	 * @param response - server information
	 * @throws IOException - handle input output exception
	 */
	@RequestMapping(value = "do_login", method = RequestMethod.POST)
	public void loginUser(@RequestParam("username") String username, @RequestParam("password") String password,
			Model model, HttpSession session, HttpServletResponse response) throws IOException {

		User user = this.authService.getUserByUsernameAndPassword(username, password);
		PrintWriter out = response.getWriter();

		if (user == null) {
			out.println("<script type=\"text/javascript\">");
			out.println("alert(\"Either Username or Password is incorrect or the User does not exist!\");");
			out.println("window.location = \"/login\";");
			out.println("</script>");
		} else {

			List<Author> listOfAuthors = this.authorService.getAuthors();

			session.setAttribute("listOfAuthors", listOfAuthors);
			session.setAttribute("username", user.getUsername());
			session.setAttribute("user", user);

			out.println("<script type=\"text/javascript\">");
			out.println("alert(\"Login Successful!\");");
			out.println("window.location = \"/show_books\";");
			out.println("</script>");
		}

	}

}