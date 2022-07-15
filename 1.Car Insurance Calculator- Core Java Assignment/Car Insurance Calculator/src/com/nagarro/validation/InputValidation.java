package com.nagarro.validation;

import com.nagarro.constant.ConsoleMessages;

public class InputValidation {

	public static boolean isValidCarType(String carType) {
		boolean choice = false;

		switch (carType) {
		case ConsoleMessages.ONE:
			choice = true;
			break;
		case ConsoleMessages.TWO:
			choice = true;
			break;
		case ConsoleMessages.THREE:
			choice = true;
			break;
		case ConsoleMessages.BASIC:
			choice = true;
			break;
		case ConsoleMessages.SEDAN:
			choice = true;
			break;
		case ConsoleMessages.SUV:
			choice = true;

			break;
		default:
			choice = false;
		}

		return choice;
	}

	public static boolean isValidInsurance(String carInsurance) {
		boolean choice = false;

		switch (carInsurance) {
		case ConsoleMessages.ONE:
			choice = true;
			break;
		case ConsoleMessages.TWO:
			choice = true;
			break;
		case ConsoleMessages.BASIC:
			choice = true;
			break;
		case ConsoleMessages.PREMIUM:
			choice = true;
			break;
		default:
			choice = false;
		}

		return choice;

	}

	public static void checkingLimit(int limit) {
		if (limit > 3) {
			System.out.println(ConsoleMessages.LIMIT_REACHED);
			System.exit(0);
		}
	}

}
