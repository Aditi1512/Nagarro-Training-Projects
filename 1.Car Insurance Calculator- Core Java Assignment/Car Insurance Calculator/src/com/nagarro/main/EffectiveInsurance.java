package com.nagarro.main;

import java.util.*;

import com.nagarro.io.*;
import com.nagarro.model.*;
import com.nagarro.service.impl.CarInsuranceCalculator;

public class EffectiveInsurance {

	public static void main(String[] args) {

		System.out.println("Enter Car Details: ");
		List<CarModel> cars = new ArrayList<>();
		cars = InputCarDetails.getInputFromUser();
		cars = CarInsuranceCalculator.carInsuranceCalculator(cars);
		OutputCarDetails.displayCarDetails(cars);

	}

}
