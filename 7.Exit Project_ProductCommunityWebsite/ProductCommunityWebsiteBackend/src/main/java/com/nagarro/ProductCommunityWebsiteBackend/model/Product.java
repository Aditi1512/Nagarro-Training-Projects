package com.nagarro.ProductCommunityWebsiteBackend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * This is the model class for Product that contains attribute associated with a
 * product.
 */
@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int productId;
	private String productBrand;
	private String productCode;
	private String productName;
	private double productPrice;
	private String productSeller;

	public Product() {
		super();
	}

	public Product(String productBrand, String productCode, String productName, double productPrice,
			String productSeller) {
		super();
		this.productBrand = productBrand;
		this.productCode = productCode;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productSeller = productSeller;

	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductBrand() {
		return productBrand;
	}

	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductSeller() {
		return productSeller;
	}

	public void setProductSeller(String productSeller) {
		this.productSeller = productSeller;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productBrand=" + productBrand + ", productCode=" + productCode
				+ ", productName=" + productName + ", productPrice=" + productPrice + ", productSeller="
				+ productSeller;
	}

}
