package com.nagarro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 * This class is a model class of T-shirt.
 *
 */
@Entity
public class Tshirt {

	@Id
	@Column(name = "TshirtID")
	String tShirtId;
	@Column(name = "Name")
	String tShirtName;
	@Column(name = "Color")
	String tShirtColor;
	@Column(name = "Gender")
	char gender;
	@Column(name = "Size")
	String tShirtSize;
	@Column(name = "Price")
	float tShirtPrice;
	@Column(name = "Rating")
	float tShirtRating;
	@Column(name = "Availability")
	char tShirtAvailability;
	@Transient
	String outputPreference;

	public Tshirt() {
	}

	public Tshirt(String tShirtColor, char gender, String tShirtSize, String outputPreference) {
		super();
		this.tShirtColor = tShirtColor;
		this.gender = gender;
		this.tShirtSize = tShirtSize;
		this.outputPreference = outputPreference;
	}

	public Tshirt(String tShirtId, String tShirtName, String tShirtColor, char gender, String tShirtSize,
			float tShirtPrice, float tShirtRating, char tShirtAvailability) {
		super();
		this.tShirtId = tShirtId;
		this.tShirtName = tShirtName;
		this.tShirtColor = tShirtColor;
		this.gender = gender;
		this.tShirtSize = tShirtSize;
		this.tShirtPrice = tShirtPrice;
		this.tShirtRating = tShirtRating;
		this.tShirtAvailability = tShirtAvailability;
	}

	public String getTshirtId() {
		return tShirtId;
	}

	public String getTshirtName() {
		return tShirtName;
	}

	public String getTshirtColor() {
		return tShirtColor;
	}

	public char getGender() {
		return gender;
	}

	public String getTshirtSize() {
		return tShirtSize;
	}

	public float getTshirtPrice() {
		return tShirtPrice;
	}

	public float getTshirtRating() {
		return tShirtRating;
	}

	public char getTshirtAvailability() {
		return tShirtAvailability;
	}

	public String getOutputPreference() {
		return outputPreference;
	}

}