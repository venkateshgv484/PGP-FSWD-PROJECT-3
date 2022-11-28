package com.simplilearn.sportyshoes.entity;

import java.math.BigDecimal;

public class PurchaseItem {

	private long ID;
	private long purchaseId;
	private long productId;
	private long userId;
	private BigDecimal rate;
	private int qty;
	private BigDecimal price;

	public long getID() {
		return this.ID;
	}

	public long getPurchaseId() {
		return this.purchaseId;
	}

	public long getProductId() {
		return this.productId;
	}

	public long getUserId() {
		return this.userId;
	}

	public BigDecimal getRate() {
		return this.rate;
	}

	public int getQty() {
		return this.qty;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setID(long id) {
		this.ID = id;
	}

	public void setPurchaseId(long value) {
		this.purchaseId = value;
	}

	public void setProductId(long value) {
		this.productId = value;
	}

	public void setUserId(long value) {
		this.userId = value;
	}

	public void setRate(BigDecimal value) {
		this.rate = value;
	}

	public void setQty(int value) {
		this.qty = value;
	}

	public void setPrice(BigDecimal value) {
		this.price = value;
	}

}
