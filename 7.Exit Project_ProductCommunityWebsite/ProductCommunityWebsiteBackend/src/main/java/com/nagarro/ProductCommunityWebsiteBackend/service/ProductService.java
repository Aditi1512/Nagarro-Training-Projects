package com.nagarro.ProductCommunityWebsiteBackend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nagarro.ProductCommunityWebsiteBackend.model.Product;

/**
 * Service Interface for Product.
 */
@Service
public interface ProductService {

	/**
	 * this method is to get a product associated with provided product id.
	 * 
	 * @param id - id of product which has to be returned.
	 * @return product associated with a provided id.
	 */
	public Optional<Product> getProductById(int id);

	/**
	 * this method is to add product to database.
	 * 
	 * @param product - product that has to be added to database.
	 * @return response after adding product.
	 */
	public Product addProduct(Product product);

	/**
	 * this method is to get list of all product present in database.
	 * 
	 * @return list of all product.
	 */
	public List<Product> getProducts();

	/**
	 * this method is to get list of all product matched either with provided brand,
	 * name or code
	 * 
	 * @param value - brand, name or code of product
	 * @return list of all products.
	 */
	public List<Product> searchedProduct(String value);

	/**
	 * this method is to get list of all products associated with provided product
	 * brand.
	 * 
	 * @param brand - brand of product.
	 * @return list of all products associated with a product brand.
	 */
	public List<Product> filterProductsByBrand(String brand);

}
