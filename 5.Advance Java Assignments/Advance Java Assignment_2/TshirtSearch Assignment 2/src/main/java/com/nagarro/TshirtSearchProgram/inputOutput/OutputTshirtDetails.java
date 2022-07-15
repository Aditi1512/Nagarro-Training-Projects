package com.nagarro.TshirtSearchProgram.inputOutput;

import java.util.List;

import com.nagarro.TshirtSearchProgram.constant.Constant;
import com.nagarro.TshirtSearchProgram.model.Tshirt;

/**
 * 
 * This class consist of a display function to display sorted list of t-shirt.
 *
 */
public class OutputTshirtDetails {

	/**
	 * This method display a sorted list of t-shirt that user wants.
	 * 
	 * @param resultedTshirtList- a sorted list of t-shirt that user wants.
	 */
	public static void displayTshirt(List<Tshirt> resultedTshirtList) {

		if (resultedTshirtList.isEmpty()) {
			System.out.println(Constant.TSHIRT_UNAVAILABLE + "\n");
		} else {

			System.out.println(Constant.RESULT);
			System.out.printf("%18s %28s %14s %13s %8s %9s %10s %3s %10s", "Tshirt-ID", "Tshirt-Brand", "Color",
					"Gender", "Size", "Price", "Rating", "", "Availability");
			System.out.println();
			System.out.println(Constant.DASHES);
			for (Tshirt sortedList : resultedTshirtList) {

				if (sortedList.getTshirtAvailability() == 'Y') {
					System.out.format("%20s %30s %10s %10s %10s %10s %10s %10s", sortedList.getTshirtId(),
							sortedList.getTshirtBrandName(), sortedList.getTshirtColor(),
							sortedList.getGenderRecommendation(), sortedList.getTshirtSize(),
							sortedList.getTshirtPrice(), sortedList.getTshirtRating(),
							sortedList.getTshirtAvailability());
					System.out.println();
					System.out.println(Constant.DASHES);
				} else {
					System.out.format("%20s %30s %10s %10s %10s %10s %10s %10s", sortedList.getTshirtId(),
							sortedList.getTshirtBrandName(), sortedList.getTshirtColor(),
							sortedList.getGenderRecommendation(), sortedList.getTshirtSize(),
							sortedList.getTshirtPrice(), sortedList.getTshirtRating(),
							sortedList.getTshirtAvailability());
					System.out.println();
					System.out.println(Constant.DASHES);
					System.out.println(Constant.TSHIRT_UNAVAILABLE + "\n");
				}
			}
		}
	}
}
