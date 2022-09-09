package com.nagarro.ProductCommunityWebsiteBackend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This is the model class for Review of a Product that contains attribute
 * associated with a review.
 */
@Entity
@Table(name = "reviews")
public class ProductReview {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int code;
	private int reviewId;
	private int rating;
	private String title;
	private String description;
	private String reviewStatus;

	public ProductReview() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return reviewStatus;
	}

	public void setStatus(String reviewStatus) {
		this.reviewStatus = reviewStatus;
	}

	@Override
	public String toString() {
		return "ProductReview [code=" + code + ", reviewId=" + reviewId + ", rating=" + rating + ", title=" + title
				+ ", description=" + description + ", reviewStatus=" + reviewStatus + "]";
	}

}
