package com.Ecom.Drone_Market.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Product {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(length=500)
	private String title;
	@Column(length=5000)
	private String description;
	
	private String category;
	
	private Double price;
	
	private int stock;
	
	private String image;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Product(int id, String title, String description, String category, Double price, int stock, String image) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.category = category;
		this.price = price;
		this.stock = stock;
		this.image = image;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", title=" + title + ", description=" + description + ", category=" + category
				+ ", price=" + price + ", stock=" + stock + ", image=" + image + "]";
	}
	
	
	
	
	
}
