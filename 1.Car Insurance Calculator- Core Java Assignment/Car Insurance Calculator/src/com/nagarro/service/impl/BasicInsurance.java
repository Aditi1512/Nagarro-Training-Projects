package com.nagarro.service.impl;

import com.nagarro.service.InsuranceType;

public class BasicInsurance implements InsuranceType {

	@Override
	public double calculateTotalInsurance(double effectiveInsuranceCost, double carPrice) {

		return effectiveInsuranceCost;
	}
}
