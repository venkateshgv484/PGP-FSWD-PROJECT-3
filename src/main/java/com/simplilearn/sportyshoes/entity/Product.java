package com.simplilearn.sportyshoes.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Product {

	private long ID;
	private String name;
	private BigDecimal price;
	private Date dateAdded;
	private long categoryId;

	public long getID() {
		return this.ID;
	}

	public String getName() {
		return this.name;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public long getCategoryId() {
		return this.categoryId;
	}

	public Date getDateAdded() {
		return this.dateAdded;
	}

	public void setID(long id) {
		this.ID = id;
	}

	public void setName(String value) {
		this.name = value;
	}

	public void setPrice(BigDecimal value) {
		this.price = value;
	}

	public void setCategoryId(long value) {
		this.categoryId = value;
	}

	public void setDateAdded(Date date) {
		this.dateAdded = date;
	}
}
