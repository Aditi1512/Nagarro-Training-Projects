package com.nagarro.ProductCommunityWebsiteBackend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nagarro.ProductCommunityWebsiteBackend.model.ProductReview;

/**
 * Service Interface for Review of a Product.
 */
@Service
public interface ProductReviewService {

	/**
	 * this method is to get list of all reviews associated with provided product
	 * id.
	 * 
	 * @param id - id of product whose reviews is to be returned.
	 * @return list of all reviews associated with a product.
	 */
	List<ProductReview> getReviewsByProductId(int id);

	/**
	 * this method is to add a review for a product.
	 * 
	 * @param review - review that has to be added for a product.
	 * @return response after adding a particular review in database
	 */
	public ProductReview addReview(ProductReview review);

	/**
	 * this method is to get list of all reviews present in database.
	 * 
	 * @return list of all reviews.
	 */
	List<ProductReview> getAllReviews();

	/**
	 * this method is to calculate average rating associated with a product whose
	 * product id is provided.
	 * 
	 * @param id - id of product whose average rating needs to be calculated.
	 * @return average rating of a product.
	 */
	public float getAverageRating(int id);

	/**
	 * this method is to get a review associated with provided review id.
	 * 
	 * @param code - id of review that has to be returned.
	 * @return a review
	 */
	public Optional<ProductReview> getReviewById(int code);

	/**
	 * this method is to update review status associated with a review of provided
	 * review id.
	 * 
	 * @param id - id of product whose reviews is to be returned.
	 * @return updated review status.
	 */
	public int updateReviewStatus(int code, String reviewStatus);
}
