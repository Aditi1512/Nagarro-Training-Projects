package com.nagarro.ProductCommunityWebsiteBackend.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.ProductCommunityWebsiteBackend.model.Product;
import com.nagarro.ProductCommunityWebsiteBackend.service.ProductService;

/**
 * This Product Controller class is responsible for processing incoming REST API
 * requests, preparing a model, and returning the view to be rendered as a
 * response.
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/product/")
public class ProductController {

	@Autowired
	private ProductService productService;

	/**
	 * this method is to build add product REST API
	 * 
	 * @param product - product that has to be added
	 * @return response after adding product in database
	 */
	@PostMapping
	public ResponseEntity<Product> addProduct(@RequestBody Product product) {

		return new ResponseEntity<Product>(productService.addProduct(product), HttpStatus.CREATED);
	}

	/**
	 * this method is to build get product by id REST API
	 * 
	 * @param id - id of the product which has to be returned
	 * @return product of provided id
	 */
	@GetMapping("id/{id}")
	public Optional<Product> getProductById(@PathVariable("id") int id) {

		return productService.getProductById(id);

	}

	/**
	 * this method is to build product searched by either brand, name or code REST
	 * API
	 * 
	 * @param value - either brand, name or code of product that has to be returned
	 * @return list of product matched with provided brand, name or code
	 */
	@GetMapping("name/{value}")
	public List<Product> searchProducts(@PathVariable("value") String value) {

		return productService.searchedProduct(value);

	}

	/**
	 * this method is to return list of all products present in database
	 * 
	 * @return list of all products
	 */
	@GetMapping
	public List<Product> getProducts() {

		return productService.getProducts();
	}

	/**
	 * this method is to build filter products by brand REST API
	 * 
	 * @param brand - brand of products
	 * @return products of provided brand
	 */
	@GetMapping("filter/{brand}")
	public List<Product> filterProductsByBrand(@PathVariable("brand") String brand) {

		return productService.filterProductsByBrand(brand);

	}

	/**
	 * this method is to get total number of products
	 *
	 */
	@GetMapping("/totalProducts")
	public int getTotalNumberOfAdmins() {

		int totalProductCount;
		if (productService.getProducts().isEmpty()) {
			totalProductCount = 0;
		} else {
			totalProductCount = productService.getProducts().size();
		}

		return totalProductCount;
	}
}
