package com.nagarro.ProductCommunityWebsiteBackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nagarro.ProductCommunityWebsiteBackend.model.ProductReview;

/**
 * This interface is a Review of Product repository interface for performing
 * CRUD operation on data associated with Review table.
 *
 */
@Repository
public interface ProductReviewRepository extends JpaRepository<ProductReview, Integer> {

	/**
	 * query to fetch all reviews associated with a product whose id is provided
	 */
	@Query("from ProductReview where reviewId = ?1")
	List<ProductReview> findAllReviews(int id);

	/**
	 * query to calculate average rating for a product whose id is provided
	 */
	@Query("select avg(rating) from ProductReview where reviewId = :reviewId")
	Float getAverageRating(int reviewId);

	/**
	 * query to update status of review whose id is provided
	 */
	@Transactional
	@Modifying
	@Query("update ProductReview SET reviewStatus = :reviewStatus WHERE code = :code")
	int updateReviewStatus(int code, String reviewStatus);

}
