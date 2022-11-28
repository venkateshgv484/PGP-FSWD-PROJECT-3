package com.simplilearn.sportyshoes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.simplilearn.sportyshoes.dao.UserDao;
import com.simplilearn.sportyshoes.entity.User;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserDao userDao;

	@Transactional
	public User authenticate(String userId, String pwd) {
		return userDao.authenticate(userId, pwd);
	}

	@Transactional
	public User getUserById(long id) {
		return userDao.getUserById(id);
	}

	@Transactional
	public User getUserByEmailId(String emailId) {
		return userDao.getUserByEmailId(emailId);
	}

	@Transactional
	public void updateUser(User user) {
		if (user.getID() == Long.valueOf(0)) {
			userDao.createUser(user);
			return;
		}
		
		userDao.updateUser(user);
	}

	@Transactional
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}
}
