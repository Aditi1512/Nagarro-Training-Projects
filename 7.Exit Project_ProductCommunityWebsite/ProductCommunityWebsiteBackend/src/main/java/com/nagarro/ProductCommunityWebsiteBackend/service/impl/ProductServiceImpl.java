package com.nagarro.ProductCommunityWebsiteBackend.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.ProductCommunityWebsiteBackend.model.Product;
import com.nagarro.ProductCommunityWebsiteBackend.repository.ProductRepository;
import com.nagarro.ProductCommunityWebsiteBackend.service.ProductService;

/**
 * This class is service implementation Product service interface.
 *
 */
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	/**
	 * this method is to return a product associated with a provided product id.
	 */
	@Override
	public Optional<Product> getProductById(int id) {
		return productRepository.findById(id);
	}

	/**
	 * this method is to add product to database.
	 */
	@Override
	public Product addProduct(Product product) {
		return productRepository.save(product);
	}

	/**
	 * this method is to return list of all product present in database.
	 */
	@Override
	public List<Product> getProducts() {
		return productRepository.findAll();
	}

	/**
	 * this method is to return list of all product matched with value that is
	 * either brand, name or code.
	 */
	@Override
	public List<Product> searchedProduct(String value) {
		return productRepository.findProduct(value);
	}

	/**
	 * this method is to return list of all products of provided brand.
	 */
	@Override
	public List<Product> filterProductsByBrand(String brand) {

		return productRepository.getFilteredProducts(brand);
	}

}
