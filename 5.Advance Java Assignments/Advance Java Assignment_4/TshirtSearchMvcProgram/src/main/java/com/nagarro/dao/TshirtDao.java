package com.nagarro.dao;

import java.util.List;

import com.nagarro.model.*;

public interface TshirtDao {

	public void saveData(List<Tshirt> tshirtList);

	public List<Tshirt> getData(String color, String size, String gender, String outputPreference);

}