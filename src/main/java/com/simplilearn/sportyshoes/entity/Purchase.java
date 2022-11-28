package com.simplilearn.sportyshoes.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Purchase {

	private long ID;
	private long userId;
	private Date date;
	private BigDecimal total;

	public long getID() {
		return this.ID;
	}

	public long getUserId() {
		return this.userId;
	}

	public BigDecimal getTotal() {
		return this.total;
	}

	public Date getDate() {
		return this.date;
	}

	public void setID(long id) {
		this.ID = id;
	}

	public void setUserId(long value) {
		this.userId = value;
	}

	public void setTotal(BigDecimal value) {
		this.total = value;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
