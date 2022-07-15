package com.nagarro.service.impl;

import com.nagarro.constant.ConsoleMessages;
import com.nagarro.service.CarType;

public class Sedan implements CarType {
	@Override
	public double calculateEffectiveInsurance(double carPrice) {
		double basicInsurance = 0.0;
		try {
			basicInsurance = (8 * carPrice) / 100;
		} catch (ArithmeticException e) {
			System.out.println(ConsoleMessages.ERROR);
		}
		return basicInsurance;
	}
}