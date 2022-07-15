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

import com.nagarro.serviceImplementation.UserServiceImpl;

/**
 * This class handle Login request.
 *
 */
@Controller
public class LoginController {

	@Autowired
	private UserServiceImpl userService;

	/**
	 * 
	 * This method is to redirect to search page and whether user exist or not.
	 * 
	 * @param username - user name of user
	 * @param password - password of user
	 * @param request  - get request
	 * @param response - send request
	 * @return redirect to search page
	 * @throws IOException
	 */
	@RequestMapping("login")
	public ModelAndView login(@RequestParam("username") String username, @RequestParam("password") String password,
			HttpServletRequest request, HttpServletResponse response) throws IOException {

		ModelAndView mv = new ModelAndView();

		PrintWriter out = response.getWriter();

		if (!userService.validateUser(username, password)) {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Either User is not registered or password is wrong!');");
			out.println("window.location = \"/TshirtSearchMvcProgram/login.jsp\";");
			out.println("</script>");
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			mv.setViewName("tshirtManagement.jsp");
		}
		return mv;

	}

}