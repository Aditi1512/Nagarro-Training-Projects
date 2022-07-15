package com.nagarro.service.impl;

import com.nagarro.constant.ConsoleMessages;
import com.nagarro.service.InsuranceType;

public class PremiumInsurance implements InsuranceType {

	@Override
	public double calculateTotalInsurance(double effectiveInsuranceCost, double carPrice) {

		double premiumCarInsurance = 0.0;
		try {
			premiumCarInsurance = effectiveInsuranceCost + (20 * effectiveInsuranceCost) / 100;
		} catch (ArithmeticException e) {
			System.out.println(ConsoleMessages.ERROR);
		}
		return premiumCarInsurance;
	}

}
