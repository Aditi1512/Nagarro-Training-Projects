package com.nagarro.LibraryManagementFrontend.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.nagarro.LibraryManagementFrontend.model.User;
import com.nagarro.LibraryManagementFrontend.service.AuthenticationService;

/**
 * This Register Controller class handle all register a user request for a web
 * applications.
 *
 */
@Controller
public class RegisterController {

	@Autowired
	private AuthenticationService authService;

	/**
	 * this method opens register page
	 * 
	 * @return register page
	 */
	@RequestMapping("/register")
	public String showRegisterPage() {
		return "register";
	}

	/**
	 * 
	 * @param user     current user
	 * @param username - user name
	 * @param password - user password
	 * @param session  - current session
	 * @param response - server information
	 * @throws IOException - handle input output request
	 */
	@RequestMapping(value = "/do_register", method = RequestMethod.POST)
	public void registerUser(@ModelAttribute("user") User user, @RequestParam("username") String username,
			@RequestParam("password") String password, HttpSession session, HttpServletResponse response)
			throws IOException {

		User existingUser = this.authService.getUserByUsernameAndPassword(username, password);

		PrintWriter out = response.getWriter();

		if (existingUser != null) {
			out.println("<script type=\"text/javascript\">");
			out.println("alert(\"User already exist.Please Login.\");");
			out.println("window.location = \"/login\";");
			out.println("</script>");
		}

		else if (username.length() >= 5 && username.length() <= 50 && password.length() >= 5
				&& password.length() <= 50) {
			this.authService.addUser(user);
			out.println("<script type=\"text/javascript\">");
			out.println("alert(\"Registration Successfull\");");
			out.println("window.location = \"/login\";");
			out.println("</script>");

		} else {
			out.println("<script type=\"text/javascript\">");
			out.println("alert(\"Length of Username and Password should be between 5-50\");");
			out.println("window.location = \"/register\";");
			out.println("</script>");

		}
	}
}