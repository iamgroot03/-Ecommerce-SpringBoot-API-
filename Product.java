package com.example.demo.Enities;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="p_name")
	private String pName;
	
	@Column(name="p_price")
	private String price;
	
	@Column(name="m_date")
	@CreationTimestamp
	private String menufechaDate;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(Long id, String pName, String price, String menufechaDate) {
		super();
		this.id = id;
		this.pName = pName;
		this.price = price;
		this.menufechaDate = menufechaDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getMenufechaDate() {
		return menufechaDate;
	}

	public void setMenufechaDate(String menufechaDate) {
		this.menufechaDate = menufechaDate;
	}
	
	

}
