package com.nagarro.validation;

import com.nagarro.constant.ConsoleMessages;

public class CarTypes {

	public static String getCarTypes(String inputCarType) {
		String carType;

		if (inputCarType.equalsIgnoreCase(ConsoleMessages.ONE)
				|| inputCarType.equalsIgnoreCase(ConsoleMessages.HATCHBACK)) {
			carType = "hatchback";
		} else if (inputCarType.equalsIgnoreCase(ConsoleMessages.TWO)
				|| inputCarType.equalsIgnoreCase(ConsoleMessages.SEDAN)) {
			carType = "sedan";
		} else {
			carType = "suv";
		}
		return carType;

	}
}
