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

import com.simplilearn.sportyshoes.dao.CategoryDao;
import com.simplilearn.sportyshoes.entity.Category;

@Repository(value = "categoryDao")
public class CategoryDaoImpl implements CategoryDao {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public Category getCategoryById(long id) {
		String query = "select * from category where id = :id";
		SqlParameterSource paramMap = new MapSqlParameterSource().addValue("id", id);
		return namedParameterJdbcTemplate.queryForObject(query, paramMap, new CategoryRowMapper());
	}

	@Override
	public void createCategory(Category category) {
		String query = "insert into category (name) values (:name)";
		SqlParameterSource paramMap = new MapSqlParameterSource().addValue("name", category.getName());
		namedParameterJdbcTemplate.update(query, paramMap);
	}

	@Override
	public void updateCategory(Category category) {
		String query = "update category set name = :name where id = :id";
		SqlParameterSource paramMap = new MapSqlParameterSource().addValue("id", category.getID()).addValue("name",
				category.getName());
		namedParameterJdbcTemplate.update(query, paramMap);
	}

	@Override
	public void deleteCategory(long id) {
		String query = "udelete from category where id = :id";
		SqlParameterSource paramMap = new MapSqlParameterSource().addValue("id", id);
		namedParameterJdbcTemplate.update(query, paramMap);
	}

	@Override
	public List<Category> getAllCategories() {
		String query = "select * from category";
		SqlParameterSource paramMap = new MapSqlParameterSource();
		return namedParameterJdbcTemplate.query(query, paramMap, new CategoryRowMapper());
	}

	private class CategoryRowMapper implements RowMapper<Category> {

		@Override
		public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
			Category category = new Category();
			category.setID(rs.getLong("id"));
			category.setName(rs.getNString("name"));
			return category;
		}

	}

}
