package com.nagarro.service.impl;

import java.util.Iterator;
import java.util.List;

import com.nagarro.constant.ConsoleMessages;
import com.nagarro.model.CarModel;
import com.nagarro.service.CarType;
import com.nagarro.service.InsuranceType;

public class CarInsuranceCalculator {

	public static List<CarModel> carInsuranceCalculator(List<CarModel> cars) {

		Iterator<CarModel> iterator = cars.iterator();
		while (iterator.hasNext()) {
			CarModel car = iterator.next();
			double carPrice = car.getCarPrice();
			String carType = car.getCarType();
			CarType typeOfCar;
			if (carType.equalsIgnoreCase(ConsoleMessages.HATCHBACK)) {
				typeOfCar = new Hatchback();
			} else if (carType.equalsIgnoreCase(ConsoleMessages.SEDAN)) {
				typeOfCar = new Sedan();
			} else {
				typeOfCar = new Suv();
			}
			double effectiveInsuranceCost = typeOfCar.calculateEffectiveInsurance(carPrice);
			String insuranceType = car.getInsuranceType();
			InsuranceType typeOfInsurance;
			if (insuranceType.equalsIgnoreCase(ConsoleMessages.BASIC)) {
				typeOfInsurance = new BasicInsurance();
			} else {
				typeOfInsurance = new PremiumInsurance();
			}
			double totalInsuranceCost = typeOfInsurance.calculateTotalInsurance(effectiveInsuranceCost, carPrice);
			car.setTotalInsurance(totalInsuranceCost);
		}
		return cars;

	}
}
