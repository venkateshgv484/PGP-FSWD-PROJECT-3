package com.simplilearn.sportyshoes.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.simplilearn.sportyshoes.dao.UserDao;
import com.simplilearn.sportyshoes.entity.User;

@Repository(value = "userDao")
public class UserDaoImpl implements UserDao {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public User getUserById(long id) {
		String query = "select * from users where id = :id";
		SqlParameterSource paramMap = new MapSqlParameterSource().addValue("id", id);
		return namedParameterJdbcTemplate.queryForObject(query, paramMap, new UserRowMapper());
	}

	@Override
	public User authenticate(String emailId, String pwd) {
		String query = "select * from users where emailid = :emailid and pwd = :pwd";
		SqlParameterSource paramMap = new MapSqlParameterSource().addValue("emailid", emailId).addValue("pwd", pwd);
		return namedParameterJdbcTemplate.queryForObject(query, paramMap, new UserRowMapper());
	}

	@Override
	public User getUserByEmailId(String emailId) {
		String query = "select * from users where emailid = :emailid";
		SqlParameterSource paramMap = new MapSqlParameterSource().addValue("emailid", emailId);
		return namedParameterJdbcTemplate.queryForObject(query, paramMap, new UserRowMapper());
	}

	@Override
	public List<User> getAllUsers() {
		String query = "select * from users";
		return namedParameterJdbcTemplate.query(query, new UserRowMapper());
	}

	@Override
	public void updateUser(User user) {
		String query = "update users set fname = :fname, lname = :lname, address = :address, age = :age, date_added = :date_added, emailid = :emailid, pwd = :pwd where id = :id";
		SqlParameterSource paramMap = new MapSqlParameterSource().addValue("id", user.getID())
				.addValue("fname", user.getFname()).addValue("lname", user.getLname())
				.addValue("address", user.getAddress()).addValue("age", user.getAge())
				.addValue("date_added", user.getDateAdded()).addValue("emailid", user.getEmail())
				.addValue("pwd", user.getPwd());
		namedParameterJdbcTemplate.update(query, paramMap);
	}

	@Override
	public void createUser(User user) {
		String query = "insert into users (fname, lname, address, age, date_added, emailid, pwd) values(:fname, :lname, :address, :age, :date_added, :emailid, :pwd)";
		SqlParameterSource paramMap = new MapSqlParameterSource().addValue("fname", user.getFname())
				.addValue("lname", user.getLname()).addValue("address", user.getAddress())
				.addValue("age", user.getAge()).addValue("date_added", user.getDateAdded())
				.addValue("emailid", user.getEmail()).addValue("pwd", user.getPwd());
		namedParameterJdbcTemplate.update(query, paramMap);
	}

	private class UserRowMapper implements RowMapper<User> {

		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			user.setID(rs.getLong("id"));
			user.setFname(rs.getNString("fname"));
			user.setLname(rs.getNString("lname"));
			user.setAddress(rs.getNString("address"));
			user.setAge(rs.getInt("age"));
			user.setDateAdded(rs.getDate("date_added"));
			user.setEmail(rs.getNString("emailid"));
			user.setPwd(rs.getNString("pwd"));
			return user;
		}

	}

}
