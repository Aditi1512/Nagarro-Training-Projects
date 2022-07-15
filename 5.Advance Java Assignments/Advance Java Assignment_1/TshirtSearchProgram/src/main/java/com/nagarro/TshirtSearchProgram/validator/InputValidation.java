package com.nagarro.TshirtSearchProgram.validator;

import com.nagarro.TshirtSearchProgram.constant.Constant;

public class InputValidation {

	public static boolean isValidGender(char gender) {
		boolean isValid = false;

		if (gender == Constant.MALE || gender == Constant.FEMALE || gender == Constant.UNISEX) {
			isValid = true;
		}

		else {
			System.out.println(Constant.GENDER_ERROR);
		}
		return isValid;
	}

	public static boolean isValidChoice(char choice) {
		boolean isValid = false;
		if (choice == 'Y' || choice == 'N')
			isValid = true;
		return isValid;

	}

	public static boolean isValidOutputPreference(String data) {
		boolean isValidPreference = false;

		switch (data) {
		case Constant.PRICE:
			isValidPreference = true;
			break;
		case Constant.RATING:
			isValidPreference = true;
			break;
		case Constant.BOTH:
			isValidPreference = true;
			break;
		default:
			isValidPreference = false;
			System.out.println(Constant.OUTPUT_PREFERENCE_ERROR);
		}
		return isValidPreference;
	}

}
