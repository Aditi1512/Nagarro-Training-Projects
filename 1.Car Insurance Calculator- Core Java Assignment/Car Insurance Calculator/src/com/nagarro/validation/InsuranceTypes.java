package com.nagarro.validation;

import com.nagarro.constant.ConsoleMessages;

public class InsuranceTypes {

	public static String getInsuranceType(String inputInsuranceType) {
		String insuranceType = "";
		if (inputInsuranceType.equalsIgnoreCase(ConsoleMessages.ONE)
				|| inputInsuranceType.equalsIgnoreCase(ConsoleMessages.BASIC)) {
			insuranceType = "basic";
		} else if (inputInsuranceType.equalsIgnoreCase(ConsoleMessages.TWO)
				|| inputInsuranceType.equalsIgnoreCase(ConsoleMessages.PREMIUM)) {
			insuranceType = "premium";
		}
		return insuranceType;
	}
}
