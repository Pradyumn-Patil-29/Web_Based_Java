package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="prod")
public class Product extends BaseEntity {
	
	@Column(length=20)
	private String pname;
	@Column(length=20)
	private int quantity;
	@Column(length=20)
	private double price;
	@Column(length=50)
	private String Description;
	
	public Product() {
		
	}
	
	public Product(String pname, int quantity, double price, String description) {
		super();
		this.pname = pname;
		this.quantity = quantity;
		this.price = price;
		Description = description;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	@Override
	public String toString() {
		return "Product [pname=" + pname + ", quantity=" + quantity + ", price=" + price + ", Description="
				+ Description + ", getId()=" + getId() + "]";
	}
	
	
	

}
