package com.nagarro.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.model.Tshirt;
import com.nagarro.serviceImplementation.TshirtSearchServiceImpl;

/**
 * This class to handle user's search request.
 *
 */
@Controller
public class SearchController {

	@Autowired
	private TshirtSearchServiceImpl tshirtSearch;

	/**
	 * This method is use to redirects to display page to show user search result.
	 * 
	 * @param request  - get request
	 * @param response - send response
	 * @return redirects to display search result
	 */
	@RequestMapping("/search")
	public ModelAndView searchTshirt(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView mv = new ModelAndView();

		String color = request.getParameter("color");
		String size = request.getParameter("size");
		String gender = request.getParameter("gender");
		String outputPreference = request.getParameter("outputPref");
		List<Tshirt> searchResult = tshirtSearch.getSearchResult(color, size, gender, outputPreference);

		if (searchResult.isEmpty()) {
			mv.addObject("searchResult", searchResult);
			mv.setViewName("tshirtUnavailable.jsp");
		}

		else {
			mv.addObject("searchResult", searchResult);
			mv.setViewName("display.jsp");
		}
		return mv;

	}

}