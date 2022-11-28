package com.simplilearn.sportyshoes.dao;

import java.util.List;

import com.simplilearn.sportyshoes.entity.User;

public interface UserDao {

	public User authenticate(String emailId, String pwd);

	public User getUserById(long id);

	public User getUserByEmailId(String emailId);

	public void updateUser(User user);

	public void createUser(User user);

	public List<User> getAllUsers();

}
