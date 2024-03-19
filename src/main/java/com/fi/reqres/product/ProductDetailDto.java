package com.fi.reqres.product;

import java.math.BigDecimal;

import com.fi.product.ProductDetail;

public class ProductDetailDto {
	private String id;

    private String productId;

    private String description;

    private String gender;

    private BigDecimal price;

    private String status;

    private String categoryId;



    public ProductDetailDto(ProductDetail detail) {
        this.id = detail.getId();
        this.productId = detail.getProduct().getName();
        this.categoryId = detail.getCategory().getId();
        this.description = detail.getDescription();
        this.gender = detail.getGender().name();
        this.price = detail.getPrice();
        this.status = detail.getStatus().name();
    }

	public ProductDetailDto(String id, String productId, String description, String gender, BigDecimal price,
			String status, String categoryId) {
		super();
		this.id = id;
		this.productId = productId;
		this.description = description;
		this.gender = gender;
		this.price = price;
		this.status = status;
		this.categoryId = categoryId;
	}

	public ProductDetailDto() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
    
    
}
