package com.fi.reqres.product;

import java.math.BigDecimal;
import java.util.List;

public class FindProductDetailByCategorysConvertRequest {
	private List<String> colors;
    private List<String> brands;
    private List<String> materials;
    private List<String> nameSizes;
    private List<String> soles;
    private List<String> categorys;
    private String gender;
    private List<String> statuss;
    private BigDecimal minPrice;
    private BigDecimal maxPrice;
    private String sellOff;
    private String newProduct;
	public List<String> getColors() {
		return colors;
	}
	public void setColors(List<String> colors) {
		this.colors = colors;
	}
	public List<String> getBrands() {
		return brands;
	}
	public void setBrands(List<String> brands) {
		this.brands = brands;
	}
	public List<String> getMaterials() {
		return materials;
	}
	public void setMaterials(List<String> materials) {
		this.materials = materials;
	}
	public List<String> getNameSizes() {
		return nameSizes;
	}
	public void setNameSizes(List<String> nameSizes) {
		this.nameSizes = nameSizes;
	}
	public List<String> getSoles() {
		return soles;
	}
	public void setSoles(List<String> soles) {
		this.soles = soles;
	}
	public List<String> getCategorys() {
		return categorys;
	}
	public void setCategorys(List<String> categorys) {
		this.categorys = categorys;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public List<String> getStatuss() {
		return statuss;
	}
	public void setStatuss(List<String> statuss) {
		this.statuss = statuss;
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
	public String getSellOff() {
		return sellOff;
	}
	public void setSellOff(String sellOff) {
		this.sellOff = sellOff;
	}
	public String getNewProduct() {
		return newProduct;
	}
	public void setNewProduct(String newProduct) {
		this.newProduct = newProduct;
	}
	public FindProductDetailByCategorysConvertRequest(List<String> colors, List<String> brands, List<String> materials,
			List<String> nameSizes, List<String> soles, List<String> categorys, String gender, List<String> statuss,
			BigDecimal minPrice, BigDecimal maxPrice, String sellOff, String newProduct) {
		super();
		this.colors = colors;
		this.brands = brands;
		this.materials = materials;
		this.nameSizes = nameSizes;
		this.soles = soles;
		this.categorys = categorys;
		this.gender = gender;
		this.statuss = statuss;
		this.minPrice = minPrice;
		this.maxPrice = maxPrice;
		this.sellOff = sellOff;
		this.newProduct = newProduct;
	}
	public FindProductDetailByCategorysConvertRequest() {
		super();
	}
    
    
}
