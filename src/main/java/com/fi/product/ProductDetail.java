package com.fi.product;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import com.fi.entity.PrimaryEntity;
import com.fi.entity.Status;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "product_detail")
public class ProductDetail extends PrimaryEntity {
	
	public ProductDetail(String description, Integer quantity, BigDecimal price, String name, Status status,
			Classify gender, Product product, Category category, Color color, Set<Size> size, Brand brand,
			Set<Image> images) {
		super();
		this.description = description;
		this.quantity = quantity;
		this.price = price;
		this.name = name;
		this.status = status;
		this.gender = gender;
		this.product = product;
		this.category = category;
		this.color = color;
		this.size = size;
		this.brand = brand;
		this.images = images;
	}

	private String description;
	private Integer quantity;
	private BigDecimal price;
	
	private String name;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Enumerated(EnumType.STRING)
	private Classify gender;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_product",referencedColumnName = "id")
    private Product product;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_category",referencedColumnName = "id")
    private Category category;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_color",referencedColumnName = "id")
    private Color color;
	
	@ManyToMany(fetch = FetchType.EAGER,cascade = { CascadeType.ALL })
    @JoinTable(name = "product_size",joinColumns = @JoinColumn(name = "product_id"),inverseJoinColumns = {@JoinColumn(name = "size_id")})
    private Set<Size> size = new HashSet<>();
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_brand",referencedColumnName = "id")
    private Brand brand;
	
	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	@OneToMany
    @JoinTable(name = "product_image",joinColumns = @JoinColumn(name="id_product_detail"),inverseJoinColumns = @JoinColumn(name="id_image"))
    private Set<Image> images = new HashSet<>();

	public Set<Image> getImages() {
		return images;
	}

	public void setImages(Set<Image> images) {
		this.images = images;
	}

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

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Classify getGender() {
		return gender;
	}

	public void setGender(Classify gender) {
		this.gender = gender;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}



	public Set<Size> getSize() {
		return size;
	}

	public void setSize(Set<Size> size) {
		this.size = size;
	}

	public ProductDetail() {
		super();
	}
	
	
	
}
