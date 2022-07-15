package com.nagarro.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.service.ReadFilesService;
import com.nagarro.serviceImplementation.UserServiceImpl;

/**
 * This class is use to handle user's registration request.
 *
 */
@Controller
public class RegisterController {

	@Autowired
	private ReadFilesService readFilesDirectory;

	@Autowired
	private UserServiceImpl userService;

	/**
	 * This method is use to register user and save information in database if user
	 * does not not exist in database and then redirects to login page.
	 * 
	 * @param fullname - user's full name
	 * @param username - user's unique username
	 * @param email    - user's email
	 * @param password - user's password
	 * @param request  - get request
	 * @param response - send request
	 * @return redirect to login page after user registration.
	 * @throws IOException
	 */
	@RequestMapping("/register")
	public ModelAndView register(@RequestParam("fullname") String fullname, @RequestParam("username") String username,
			@RequestParam("email") String email, @RequestParam("password") String password, HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		ModelAndView mv = new ModelAndView();

		readFilesDirectory.readDirectory();

		PrintWriter out = response.getWriter();
		boolean isNotRegisteredUser = userService.isRegisteredUser(username);

		if (isNotRegisteredUser) {
			userService.saveUser(username, fullname, password, email);
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			mv.setViewName("login.jsp");
		} else {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('The user is already Registered. Please Login.');");
			out.println("window.location = \"/TshirtSearchManagement/login.jsp\";");
			out.println("</script>");
		}
		return mv;
	}
}