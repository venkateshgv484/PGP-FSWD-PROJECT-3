package com.simplilearn.sportyshoes.entity;

public class Admin {

	private long ID;
	private String adminId;
	private String pwd;

	public long getID() {
		return this.ID;
	}

	public String getAdminId() {
		return this.adminId;
	}

	public String getAdminPwd() {
		return this.pwd;
	}

	public void setID(long id) {
		this.ID = id;
	}

	public void setAdminId(String value) {
		this.adminId = value;
	}

	public void setAdminPwd(String value) {
		this.pwd = value;
	}
}
