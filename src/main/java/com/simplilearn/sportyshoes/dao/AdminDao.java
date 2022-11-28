package com.simplilearn.sportyshoes.dao;

import com.simplilearn.sportyshoes.entity.Admin;

public interface AdminDao {

	public Admin authenticate(String adminId, String pwd);

	public Admin getAdminById(long id);

	public void updatePwd(Admin admin);

}
