package com.ust.wproduct.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="food")
public class Wproduct {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "product")
	private String product;
	@Column(name = "price")
	private int price;
	@Column(name = "image")
	private String image;
	@Column(name = "description")
	private String description;
	@Column(name = "restname")
	private String restname;
	
	public Wproduct() {
		super();
	}
	public Wproduct(String product, int price, String image, String description, String restname) {
		super();
		this.product = product;
		this.price = price;
		this.image = image;
		this.description = description;
		this.restname = restname;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRestname() {
		return restname;
	}
	public void setRestname(String restname) {
		this.restname = restname;
	}
	
	
	 
}