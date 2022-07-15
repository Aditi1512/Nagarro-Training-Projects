package com.nagarro.service;

import java.util.List;

import com.nagarro.model.Tshirt;

public interface TshirtSearchService {

	public List<Tshirt> getSearchResult(String color, String size, String gender, String outputPreference);
}
