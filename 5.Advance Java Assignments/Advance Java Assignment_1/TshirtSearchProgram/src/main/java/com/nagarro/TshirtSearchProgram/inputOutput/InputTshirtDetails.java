package com.nagarro.TshirtSearchProgram.inputOutput;

import java.util.Scanner;

import com.nagarro.TshirtSearchProgram.constant.Constant;
import com.nagarro.TshirtSearchProgram.model.Tshirt;
import com.nagarro.TshirtSearchProgram.validator.InputValidation;
import com.nagarro.TshirtSearchProgram.validator.SizeType;

public class InputTshirtDetails {

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
