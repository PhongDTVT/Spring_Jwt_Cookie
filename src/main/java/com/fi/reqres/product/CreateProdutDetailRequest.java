package com.fi.reqres.product;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;


public class CreateProdutDetailRequest {
	private String description;
	private Integer quantity;
	private BigDecimal price;
	
	private String name;
	
	private String status;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	private String gender;

    private String productId;

    private String categoryId;

    private String colorCode;

    private String sizeId;
	
    private String brandName;

    private Set<Long> imageId = new HashSet<>();

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
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

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getColorCode() {
		return colorCode;
	}

	public void setColorCode(String colorCode) {
		this.colorCode = colorCode;
	}

	public String getSizeId() {
		return sizeId;
	}

	public void setSizeId(String sizeId) {
		this.sizeId = sizeId;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public Set<Long> getImageId() {
		return imageId;
	}

	public void setImageId(Set<Long> imageId) {
		this.imageId = imageId;
	}

	public CreateProdutDetailRequest(String description, Integer quantity, BigDecimal price, String name, String status,
			String gender, String productId, String categoryId, String colorCode, String sizeId, String brandName,
			Set<Long> imageId) {
		super();
		this.description = description;
		this.quantity = quantity;
		this.price = price;
		this.name = name;
		this.status = status;
		this.gender = gender;
		this.productId = productId;
		this.categoryId = categoryId;
		this.colorCode = colorCode;
		this.sizeId = sizeId;
		this.brandName = brandName;
		this.imageId = imageId;
	}
    
    
}
