package com.nagarro.TshirtSearchProgram.utilities;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.nagarro.TshirtSearchProgram.constant.Constant;
import com.nagarro.TshirtSearchProgram.model.Tshirt;

public class SearchTshirt {

	public List<Tshirt> sortTshirtList(Tshirt userInput, List<Tshirt> tshirtFileList) {

		List<Tshirt> sortedTshirtList = tshirtFileList.stream()
				.filter(tshirt -> tshirt.getTshirtColor().equalsIgnoreCase(userInput.getTshirtColor())
						&& tshirt.getTshirtSize().equalsIgnoreCase(userInput.getTshirtSize())
						&& tshirt.getGenderRecommendation() == userInput.getGenderRecommendation())
				.collect(Collectors.toList());

		if (userInput.getOutputPreference().equalsIgnoreCase(Constant.RATING))
			Collections.sort(sortedTshirtList, new RatingComparator());
		else if (userInput.getOutputPreference().equalsIgnoreCase(Constant.PRICE))
			Collections.sort(sortedTshirtList, new PriceComparator());
		else {
			Collections.sort(sortedTshirtList, new RatingComparator());
			Collections.sort(sortedTshirtList, new PriceComparator());

		}

		return sortedTshirtList;

	}
}
