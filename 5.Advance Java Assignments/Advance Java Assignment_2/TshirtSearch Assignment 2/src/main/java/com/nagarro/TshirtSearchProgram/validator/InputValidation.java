package com.nagarro.TshirtSearchProgram.validator;

import com.nagarro.TshirtSearchProgram.constant.Constant;

/**
 * 
 * This class consist of validation function to validate the user inputs.
 * 
 */
public class InputValidation {

	/**
	 * This method checks if user entered the correct value of gender.
	 * 
	 * @param gender- the gender recommendation of t-shirt that user want.
	 * @return true is if value of gender is valid else return false
	 */
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

	/**
	 * This method checks if user entered the correct value of choice.
	 * 
	 * @param choice- the value of user's choice if user's want more t-shirt to
	 *        display.
	 * 
	 * @return true if value of user's choice is valid else returns false.
	 */
	public static boolean isValidChoice(char choice) {
		boolean isValid = false;
		if (choice == 'Y' || choice == 'N')
			isValid = true;
		return isValid;

	}

	/**
	 * This method checks if user entered the correct value of output preference.
	 * 
	 * @param outputPrefernce- the value user's preference according to which
	 *        t-shirt list is to be sorted.
	 * @return
	 */
	public static boolean isValidOutputPreference(String outputPrefernce) {
		boolean isValidPreference = false;

		switch (outputPrefernce) {
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
