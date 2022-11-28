package com.simplilearn.sportyshoes.entity;

import java.util.Date;

public class User {

	private long ID;
	private String fname;
	private String lname;
	private String address;
	private int age;
	private Date dateAdded;
	private String emailId;
	private String pwd;

	public long getID() {
		return this.ID;
	}

	public String getEmail() {
		return this.emailId;
	}

	public String getFname() {
		return this.fname;
	}

	public String getLname() {
		return this.lname;
	}

	public String getAddress() {
		return this.address;
	}

	public String getPwd() {
		return this.pwd;
	}

	public int getAge() {
		return this.age;
	}

	public Date getDateAdded() {
		return this.dateAdded;
	}

	public void setID(long id) {
		this.ID = id;
	}

	public void setEmail(String value) {
		this.emailId = value;
	}

	public void setFname(String value) {
		this.fname = value;
	}

	public void setLname(String value) {
		this.lname = value;
	}

	public void setAddress(String value) {
		this.address = value;
	}

	public void setPwd(String value) {
		this.pwd = value;
	}

	public void setAge(int value) {
		this.age = value;
	}

	public void setDateAdded(Date date) {
		this.dateAdded = date;
	}
}
