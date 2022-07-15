package com.nagarro.io;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Iterator;
import java.util.List;

import com.nagarro.constant.ConsoleMessages;
import com.nagarro.model.CarModel;

public class OutputCarDetails {
	public static void displayCarDetails(List<CarModel> cars) {

		int count = 0;
		Iterator<CarModel> iterator = cars.iterator();
		while (iterator.hasNext()) {
			CarModel car = iterator.next();
			System.out.println("\n" + "DETAILS OF CAR " + ++count);
			System.out.println("Car Model : " + car.getCarModel());
			System.out.println("Car Type : " + car.getCarType());
			System.out.println("Car InsuranceType : " + car.getInsuranceType());
			String format = "0.000";
			NumberFormat formatter = new DecimalFormat(format);
			double priceOfCar = car.getCarPrice();
			String carPrice = formatter.format(priceOfCar);
			System.out.println("Car Price : " + carPrice);
			double totalCalculatedInsuranceCost = car.getTotalInsurance();
			String totalInsuranceCost = formatter.format(totalCalculatedInsuranceCost);
			System.out.println("Total Insurance Cost :" + totalInsuranceCost);
		}
	}

	
}
