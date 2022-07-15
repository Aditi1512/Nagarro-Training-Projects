package com.nagarro.TshirtSearchProgram.validator;

import com.nagarro.TshirtSearchProgram.constant.Constant;

/**
 * 
 * This class consist of a function to get value of t-shirt size that user
 * wants.
 *
 */
public class SizeType {

	/**
	 * This method used to get the value f t-shirt size that user entered.
	 * 
	 * @param size- the t-shirt size.
	 * @return the value of t-shirt size
	 */
	public static String getSize(String size) {
		String tshirtSize;

		if (size.equalsIgnoreCase(Constant.S_SIZE) || size.equalsIgnoreCase(Constant.SMALL_SIZE)) {
			tshirtSize = Constant.S_SIZE;
		} else if (size.equalsIgnoreCase(Constant.M_SIZE) || size.equalsIgnoreCase(Constant.MEDIUM_SIZE)) {
			tshirtSize = Constant.M_SIZE;
		} else if (size.equalsIgnoreCase(Constant.L_SIZE) || size.equalsIgnoreCase(Constant.LARGE_SIZE)) {
			tshirtSize = Constant.L_SIZE;
		} else if (size.equalsIgnoreCase(Constant.XL_SIZE) || size.equalsIgnoreCase(Constant.XTRA_LARGE_SIZE)) {
			tshirtSize = Constant.XL_SIZE;
		} else {
			tshirtSize = Constant.XXL_SIZE;
		}
		return tshirtSize;

	}
}
