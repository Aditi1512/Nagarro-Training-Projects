package com.nagarro.TshirtSearchProgram.utilities;

import java.util.Comparator;

import com.nagarro.TshirtSearchProgram.model.Tshirt;

public class PriceComparator implements Comparator<Tshirt> {

	@Override
	public int compare(Tshirt tshirt1, Tshirt tshirt2) {

		return (int) (tshirt1.getTshirtPrice() - tshirt2.getTshirtPrice());
	}

}
