package com.nagarro.io;

import java.util.*;
import com.nagarro.constant.ConsoleMessages;
import com.nagarro.model.*;
import com.nagarro.validation.CarTypes;
import com.nagarro.validation.InputValidation;
import com.nagarro.validation.InsuranceTypes;

public class InputCarDetails {

	public static List<CarModel> getInputFromUser() {

		List<CarModel> cars = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		String carName;
		String carType;
		String insuranceType;
		double carPrice = 0.0;
		String getInputFromUser = "";
		char choice;
		int limit;

		// input car model
		do {
			CarModel carModel = new CarModel();

			System.out.println(ConsoleMessages.INPUT_CAR_MODEL_NAME);
			carName = getInputValueFromUser();

			carModel.setCarModel(carName);

			// input car type
			limit = 0;
			do {
				limit++;
				InputValidation.checkingLimit(limit);
				System.out.println(ConsoleMessages.INPUT_CAR_TYPE);
				System.out
						.println("Enter 1. For Hatchback " + "\n" + "Enter 2. For Sedan" + "\n" + "Enter 3. For SUV ");
				carType = getInputValueFromUser();
			} while (!InputValidation.isValidCarType(carType));
			carType = CarTypes.getCarTypes(carType);
			carModel.setCarType(carType);

			// input car price
			limit = 0;
			while (true) {
				limit++;
				InputValidation.checkingLimit(limit);
				System.out.println(ConsoleMessages.INPUT_CAR_PRICE);

				try {
					getInputFromUser = getInputValueFromUser();
					carPrice = Double.parseDouble(getInputFromUser);
					if (carPrice > 0) {
						break;
					}
				} catch (NumberFormatException e) {
					System.out.println(ConsoleMessages.INVALID_MESSAGE);
				}

			}
			carModel.setCarPrice(carPrice);

			// input insurance type
			limit = 0;
			do {
				limit++;
				InputValidation.checkingLimit(limit);
				System.out.println(ConsoleMessages.INPUT_INSURANCE_TYPE);
				System.out.println("Enter 1.For Basic" + "\n" + "Enter 2.For Premium");
				insuranceType = getInputValueFromUser();
			} while (!InputValidation.isValidInsurance(insuranceType));
			insuranceType = InsuranceTypes.getInsuranceType(insuranceType);
			carModel.setInsuranceType(insuranceType);

			//adding details of car model into list
			cars.add(carModel);
			
			System.out.println("Do you want to Enter Details of any other class? " + "\n" + "Enter Y/N ");
			choice = sc.next().toUpperCase().charAt(0);
			sc.nextLine();
		} while (choice == 'Y');
		sc.close();
		return cars;

	}

	private static String getInputValueFromUser() {

		Scanner sc = new Scanner(System.in);
		String inputValue = sc.nextLine().toLowerCase();
		while (inputValue != null && inputValue.trim().length() == 0) {
			if (inputValue.isEmpty() || inputValue.trim().length() == 0)
				System.out.println(ConsoleMessages.INVALID_MESSAGE);
			else
				break;
			inputValue = sc.nextLine();
		}

		return inputValue;
	}

}
