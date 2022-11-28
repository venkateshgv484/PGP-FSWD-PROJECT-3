package com.simplilearn.sportyshoes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.simplilearn.sportyshoes.dao.AdminDao;
import com.simplilearn.sportyshoes.entity.Admin;

@Service
public class AdminService {

	@Autowired
	private AdminDao adminDao;

	@Transactional
	public Admin authenticate(String adminId, String pwd) {
		return adminDao.authenticate(adminId, pwd);
	}

	@Transactional
	public Admin getAdminById(long id) {
		return adminDao.getAdminById(id);
	}

	@Transactional
	public void updatePwd(Admin admin) {
		adminDao.updatePwd(admin);
	}

}
