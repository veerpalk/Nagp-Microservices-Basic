package com.nagarro.nagp.account.dtos;

public class ProductDto {
			
		private String id;
		private String name;
		private String color;
		private String size;
		private String category;
		private String brand;
		
		private Double price;
		private Double discount;
		private Double priceAfterDiscount;
		
		private String pictureUrl;
		private String details;
		private String retunPolicy;
		
		
		
		public ProductDto() {
		}
		public ProductDto(String id, String name, String color, String size, String category, String brand,
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
		public String getColor() {
			return color;
		}
		public void setColor(String color) {
			this.color = color;
		}
		public String getSize() {
			return size;
		}
		public void setSize(String size) {
			this.size = size;
		}
		public String getCategory() {
			return category;
		}
		public void setCategory(String category) {
			this.category = category;
		}
		public String getBrand() {
			return brand;
		}
		public void setBrand(String brand) {
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
		
		
		
}
