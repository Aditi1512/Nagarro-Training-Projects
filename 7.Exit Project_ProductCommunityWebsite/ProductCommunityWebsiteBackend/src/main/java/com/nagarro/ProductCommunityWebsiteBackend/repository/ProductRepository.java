package com.nagarro.ProductCommunityWebsiteBackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nagarro.ProductCommunityWebsiteBackend.model.*;

/**
 * This interface is a Product repository interface for performing CRUD
 * operation on data associated with Product table.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	/**
	 * query to fetch products that are matched by provided value's either brand,
	 * name or code
	 */
	@Query("from Product where productBrand like concat ('%',:value,'%') OR productName like concat ('%', :value, '%') OR productCode like concat ('%', :value, '%')")
	List<Product> findProduct(String value);

	/**
	 * query to fetch or filter products according to given brand
	 */
	@Query("from Product where productBrand = ?1")
	List<Product> getFilteredProducts(String brand);
}
