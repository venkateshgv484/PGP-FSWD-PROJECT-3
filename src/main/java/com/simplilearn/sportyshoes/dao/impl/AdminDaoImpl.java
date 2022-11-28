package com.simplilearn.sportyshoes.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.simplilearn.sportyshoes.dao.AdminDao;
import com.simplilearn.sportyshoes.entity.Admin;

@Repository(value = "adminDao")
public class AdminDaoImpl implements AdminDao {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public Admin authenticate(String adminId, String adminPwd) {
		String sql = "select * from admin where admin_id = :admin_id and admin_pwd = :admin_pwd";
		SqlParameterSource paramMap = new MapSqlParameterSource().addValue("admin_id", adminId).addValue("admin_pwd",
				adminPwd);
		try {
			return namedParameterJdbcTemplate.queryForObject(sql, paramMap, new AdminRowMapper());
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public Admin getAdminById(long id) {
		String sql = "select * from admin where id = :id";
		SqlParameterSource paramMap = new MapSqlParameterSource().addValue("id", id);
		try {
			return namedParameterJdbcTemplate.queryForObject(sql, paramMap, new AdminRowMapper());
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public void updatePwd(Admin admin) {
		String sql = "update admin set admin_pwd = :admin_pwd where admin_id = :admin_id";
		SqlParameterSource paramMap = new MapSqlParameterSource().addValue("admin_id", admin.getAdminId())
				.addValue("admin_pwd", admin.getAdminPwd());
		namedParameterJdbcTemplate.update(sql, paramMap);
	}

	private class AdminRowMapper implements RowMapper<Admin> {

		@Override
		public Admin mapRow(ResultSet rs, int rowNum) throws SQLException {
			Admin admin = new Admin();
			admin.setID(rs.getLong("id"));
			admin.setAdminId(rs.getNString("admin_id"));
			admin.setAdminPwd(rs.getNString("admin_pwd"));
			return admin;
		}

	}

}
