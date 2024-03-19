package com.fi.reqres.product;

import java.math.BigDecimal;

public class FindProductDetailRequest {
	private String idProduct;

    private String color;

    private String brand;

    private String product;

    private int size;

    private String category;

    private String status;

    private String gender;

    private BigDecimal minPrice;

    private  BigDecimal maxPrice;

	public String getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(String idProduct) {
		this.idProduct = idProduct;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public BigDecimal getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(BigDecimal minPrice) {
		this.minPrice = minPrice;
	}

	public BigDecimal getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(BigDecimal maxPrice) {
		this.maxPrice = maxPrice;
	}

	public FindProductDetailRequest(String color, String brand, String product, int size,
			String category, String status, String gender, BigDecimal minPrice, BigDecimal maxPrice) {
		super();
		this.color = color;
		this.brand = brand;
		this.product = product;
		this.size = size;
		this.category = category;
		this.status = status;
		this.gender = gender;
		this.minPrice = minPrice;
		this.maxPrice = maxPrice;
	}
    
    
}
