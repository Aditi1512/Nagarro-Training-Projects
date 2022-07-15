package com.nagarro.TshirtSearchProgram.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 * 
 * This class is model class for t-shirt.
 *
 */
@Entity
public class Tshirt {

	@Id
	@Column(name = "Id")
	private String tshirtId;

	@Column(name = "Name")
	private String tshirtBrandName;

	@Column(name = "Color")
	private String tshirtColor;

	@Column(name = "Gender")
	private char genderRecommendation;

	@Column(name = "Size")
	private String tshirtSize;

	@Column(name = "Price")
	private double tshirtPrice;

	@Column(name = "Rating")
	private double tshirtRating;

	@Transient
	private String outputPreference;

	@Column(name = "Availability")
	private char tshirtAvailability;

	/**
	 * non-parameterized constructor
	 */
	public Tshirt() {
	}

	/**
	 * This constructor use to initialize following parameters that corresponds to
	 * the attributes of a t-shirt data stored in CSV files.
	 * 
	 * @param tshirtId             the id of the t-shirt of String type
	 * @param tshirtBrandName      the brand name of t-shirt of String type
	 * @param tshirtColor          the color of the t-shirt of String type
	 * @param genderRecommendation the gender recommendation of t-shirt of Character
	 *                             type
	 * @param tshirtSize           the size of t-shirt of String type
	 * @param tshirtPrice          the price of t-shirt of Double type
	 * @param tshirtRating         the rating of t-shirt of Double type
	 * @param tshirtAvailability   tells whether t-shirt is available or not and is
	 *                             of Character type.
	 */
	public Tshirt(String tshirtId, String tshirtBrandName, String tshirtColor, char genderRecommendation,
			String tshirtSize, double tshirtPrice, double tshirtRating, char tshirtAvailability) {
		super();
		this.tshirtId = tshirtId;
		this.tshirtBrandName = tshirtBrandName;
		this.tshirtColor = tshirtColor;
		this.genderRecommendation = genderRecommendation;
		this.tshirtSize = tshirtSize;
		this.tshirtPrice = tshirtPrice;
		this.tshirtRating = tshirtRating;
		this.tshirtAvailability = tshirtAvailability;
	}

	/**
	 * This constructor use to initialize following parameters that corresponds to
	 * the attributes of a t-shirt that user wants.
	 * 
	 * @param tshirtColor          the color of the t-shirt of String type
	 * @param genderRecommendation the gender recommendation of t-shirt of Character
	 *                             type
	 * @param tshirtSize           the size of t-shirt of String type
	 * @param outputPreference     the user preference according to which t-shirt
	 *                             list is to be sorted
	 */
	public Tshirt(String tshirtColor, char genderRecommendation, String tshirtSize, String outputPreference) {
		super();
		this.tshirtColor = tshirtColor;
		this.genderRecommendation = genderRecommendation;
		this.tshirtSize = tshirtSize;
		this.outputPreference = outputPreference;
	}

	/**
	 * A getter function to return the value of t-shirt id.
	 * 
	 * @return t-shirt id
	 */
	public String getTshirtId() {
		return tshirtId;
	}

	/**
	 * A getter function to return the value of t-shirt brand name.
	 * 
	 * @return t-shirt brand name
	 */
	public String getTshirtBrandName() {
		return tshirtBrandName;
	}

	/**
	 * A getter function to return the value of t-shirt Color.
	 * 
	 * @return t-shirt Color
	 */
	public String getTshirtColor() {
		return tshirtColor;
	}

	/**
	 * A getter function to return the value of t-shirt Gender Recommendation.
	 * 
	 * @return t-shirt gender recommendation
	 */
	public char getGenderRecommendation() {
		return genderRecommendation;
	}

	/**
	 * A getter function to return the value of t-shirt size.
	 * 
	 * @return t-shirt size
	 */
	public String getTshirtSize() {
		return tshirtSize;
	}

	/**
	 * A getter function to return the value of t-shirt price.
	 * 
	 * @return t-shirt price
	 */
	public double getTshirtPrice() {
		return tshirtPrice;
	}

	/**
	 * A getter function to return the value of t-shirt rating.
	 * 
	 * @return t-shirt rating
	 */
	public double getTshirtRating() {
		return tshirtRating;
	}

	/**
	 * A getter function to return the value of user's output preference.
	 * 
	 * @return t-shirt output preference
	 */
	public String getOutputPreference() {
		return outputPreference;
	}

	/**
	 * A getter function to return the value of availability of t-shirt.
	 * 
	 * @return t-shirt availability
	 */
	public char getTshirtAvailability() {
		return tshirtAvailability;
	}

}
