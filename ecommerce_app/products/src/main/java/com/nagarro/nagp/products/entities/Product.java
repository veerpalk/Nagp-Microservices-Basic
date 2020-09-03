package com.nagarro.nagp.products.entities;

import com.nagarro.nagp.products.enums.BrandName;
import com.nagarro.nagp.products.enums.Category;
import com.nagarro.nagp.products.enums.Color;
import com.nagarro.nagp.products.enums.Size;

public class Product {
	
	private String id;
	private String name;
	private Color color;
	private Size size;
	private Category category;
	private BrandName brand;
	
	private Double price;
	private Double discount;
	private Double priceAfterDiscount;
	
	private String pictureUrl;
	private String details;
	private String retunPolicy;
	

	public Product(String id, String name, Color color, Size size, Category category, BrandName brand,
			Double price, Double discount, Double priceAfterDiscount, String pictureUrl, String details,
			String retunPolicy) {
		this.id = id;
		this.name = name;
		this.color = color;
		this.size = size;
		this.category = category;
		this.brand = brand;
		this.price = price;
		this.discount = discount;
		this.priceAfterDiscount = priceAfterDiscount;
		this.pictureUrl = pictureUrl;
		this.details = details;
		this.retunPolicy = retunPolicy;
	}
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public BrandName getBrand() {
		return brand;
	}

	public void setBrand(BrandName brand) {
		this.brand = brand;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public Double getPriceAfterDiscount() {
		return priceAfterDiscount;
	}

	public void setPriceAfterDiscount(Double priceAfterDiscount) {
		this.priceAfterDiscount = priceAfterDiscount;
	}

	public String getPictureUrl() {
		return pictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getRetunPolicy() {
		return retunPolicy;
	}

	public void setRetunPolicy(String retunPolicy) {
		this.retunPolicy = retunPolicy;
	}



	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", color=" + color + ", size=" + size + ", category=" + category
				+ ", brand=" + brand + ", price=" + price + ", discount=" + discount + ", priceAfterDiscount="
				+ priceAfterDiscount + ", pictureUrl=" + pictureUrl + ", details=" + details + ", retunPolicy="
				+ retunPolicy + "]";
	}
	
}
