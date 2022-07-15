package com.nagarro.serviceImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.dao.TshirtDao;
import com.nagarro.model.Tshirt;
import com.nagarro.service.TshirtSearchService;

/**
 * This class is use to get list of t-shirt from user which user want to search.
 *
 */
@Service
public class TshirtSearchServiceImpl implements TshirtSearchService {

	@Autowired
	private TshirtDao tshirtDao;

	public List<Tshirt> getSearchResult(String color, String size, String gender, String outputPreference) {

		List<Tshirt> tshirtSearchResult;

		tshirtSearchResult = tshirtDao.getData(color, size, gender, outputPreference);

		return tshirtSearchResult;

	}

}