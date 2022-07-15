package com.nagarro.TshirtSearchProgram.inputOutput;

import java.util.Scanner;

import com.nagarro.TshirtSearchProgram.constant.Constant;
import com.nagarro.TshirtSearchProgram.model.Tshirt;
import com.nagarro.TshirtSearchProgram.validator.InputValidation;
import com.nagarro.TshirtSearchProgram.validator.SizeType;

/**
 * 
 * This class consist of function to get valid input from user's.
 * 
 */
public class InputTshirtDetails {

	/**
	 * This method get valid input from users and stores it into a object.
	 * 
	 * @return T-shirt the object that stores valid user input.
	 */
	public static Tshirt getUserInput() {
		String color;
		char gender;
		String size;
		String outputPreference;

		System.out.println("Enter user input:");
		System.out.println(Constant.COLOR);

		color = getInputValue();

		System.out.println(Constant.GENDER);
		do {
			gender = getInputValue().toUpperCase().charAt(0);
		} while (!InputValidation.isValidGender(gender));

		System.out.println(Constant.SIZE);
		size = getInputValue();
		size = SizeType.getSize(size);

		System.out.println(Constant.OUTPUT_PREFERENCE);
		do {
			outputPreference = getInputValue().toLowerCase();
		} while (!InputValidation.isValidOutputPreference(outputPreference));

		return new Tshirt(color, gender, size, outputPreference);

	}

	/**
	 * This method is to get input from user's as a String.
	 * 
	 * @return inputValue a string that stores user input.
	 */
	private static String getInputValue() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String inputValue = sc.nextLine().toLowerCase();
		while (inputValue != null && inputValue.trim().length() == 0) {
			if (inputValue.isEmpty() || inputValue.trim().length() == 0)
				System.out.println(Constant.INVALID_MESSAGE);
			else
				break;
			inputValue = sc.next();
		}
		return inputValue;
	}
}
