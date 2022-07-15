package com.nagarro.TshirtSearchProgram.utilities;

import java.util.Comparator;

import com.nagarro.TshirtSearchProgram.model.Tshirt;

public class RatingComparator implements Comparator<Tshirt> {

	@Override
	public int compare(Tshirt tshirt1, Tshirt tshirt2) {
		if (tshirt1.getTshirtRating() == tshirt2.getTshirtRating())
			return 0;
		if (tshirt1.getTshirtRating() < tshirt2.getTshirtRating())
			return 1;
		else
			return -1;

	}

}
