package com.nagarro.TshirtSearchProgram.model;

public class Tshirt {

	private String tshirtId;
	private String tshirtBrandName;
	private String tshirtColor;
	private char genderRecommendation;
	private String tshirtSize;
	private String outputPreference;
	private double tshirtPrice;
	private double tshirtRating;
	private char tshirtAvailability;

	public Tshirt() {
	}

	public Tshirt(String tshirtColor, char genderRecommendation, String tshirtSize, String outputPreference) {
		super();
		this.tshirtColor = tshirtColor;
		this.genderRecommendation = genderRecommendation;
		this.tshirtSize = tshirtSize;
		this.outputPreference = outputPreference;
	}

	public String getOutputPreference() {
		return outputPreference;
	}

	public void setOutputPreference(String outputPreference) {
		this.outputPreference = outputPreference;
	}

	public String getTshirtId() {
		return tshirtId;
	}

	public void setTshirtId(String tshirtId) {
		this.tshirtId = tshirtId;
	}

	public String getTshirtBrandName() {
		return tshirtBrandName;
	}

	public void setTshirtBrandName(String tshirtBrandName) {
		this.tshirtBrandName = tshirtBrandName;
	}

	public String getTshirtColor() {
		return tshirtColor;
	}

	public void setTshirtColor(String tshirtColor) {
		this.tshirtColor = tshirtColor;
	}

	public char getGenderRecommendation() {
		return genderRecommendation;
	}

	public void setGenderRecommendation(char genderRecommendation) {
		this.genderRecommendation = genderRecommendation;
	}

	public String getTshirtSize() {
		return tshirtSize;
	}

	public void setTshirtSize(String tshirtSize) {
		this.tshirtSize = tshirtSize;
	}

	public double getTshirtPrice() {
		return tshirtPrice;
	}

	public void setTshirtPrice(double tshirtPrice) {
		this.tshirtPrice = tshirtPrice;
	}

	public double getTshirtRating() {
		return tshirtRating;
	}

	public void setTshirtRating(double tshirtRating) {
		this.tshirtRating = tshirtRating;
	}

	public char getTshirtAvailability() {
		return tshirtAvailability;
	}

	public void setTshirtAvailability(char tshirtAvailability) {
		this.tshirtAvailability = tshirtAvailability;
	}

}
