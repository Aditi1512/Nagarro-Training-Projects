package com.nagarro.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * This class handle Logout request.
 *
 */
@Controller
public class LogoutController {

	/**
	 * This method is to redirect to login and invalidate user session.
	 * 
	 * @param request  - get request
	 * @param response - send request
	 * @return redirect to search page
	 */
	@RequestMapping("/logout")
	public ModelAndView signOut(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		session.setAttribute("username", null);
		mv.setViewName("login.jsp");
		return mv;
	}

}