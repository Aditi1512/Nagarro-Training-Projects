package com.nagarro.model;

public class CarModel {

	private String carModel;
	private String carType;
	private double carPrice = 0.0;
	private String insuranceType;
	private double totalInsurance;

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarPrice(double carPrice) {
		this.carPrice = carPrice;
	}

	public double getCarPrice() {
		return carPrice;
	}

	public String getInsuranceType() {
		return insuranceType;
	}

	public void setInsuranceType(String insuranceType) {
		this.insuranceType = insuranceType;
	}

	public double getTotalInsurance() {
		return totalInsurance;
	}

	public void setTotalInsurance(double totalInsurance) {
		this.totalInsurance = totalInsurance;
	}

	@Override
	public String toString() {
		return "CarModel [carModel=" + carModel + ", carType=" + carType + ", carPrice=" + carPrice
				+ ", insuranceType =" + insuranceType + ", totalInsurance=" + totalInsurance + "]";
	}

}
