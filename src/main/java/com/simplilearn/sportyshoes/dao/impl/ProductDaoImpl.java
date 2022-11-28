package com.simplilearn.sportyshoes.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.simplilearn.sportyshoes.dao.ProductDao;
import com.simplilearn.sportyshoes.entity.Product;

@Repository(value = "productDao")
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public Product getProductById(long id) {
		String query = "select * from eproduct where id = :id";
		SqlParameterSource paramMap = new MapSqlParameterSource().addValue("id", id);
		try {
			return namedParameterJdbcTemplate.queryForObject(query, paramMap, new ProductRowMapper());
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public void createProduct(Product product) {
		String query = "insert into eproduct (name, price, date_added, category_id) values (:name, :price, :date_added, :category_id)";
		SqlParameterSource paramMap = new MapSqlParameterSource().addValue("name", product.getName())
				.addValue("price", product.getPrice()).addValue("date_added", product.getDateAdded())
				.addValue("category_id", product.getCategoryId());
		namedParameterJdbcTemplate.update(query, paramMap);
	}

	@Override
	public void updateProduct(Product product) {
		String query = "update eproduct set name = :name, price = :price, date_added = :date_added, category_id = :category_id where id = :id";
		SqlParameterSource paramMap = new MapSqlParameterSource().addValue("id", product.getID())
				.addValue("name", product.getName()).addValue("price", product.getPrice())
				.addValue("date_added", product.getDateAdded()).addValue("category_id", product.getCategoryId());
		namedParameterJdbcTemplate.update(query, paramMap);
	}

	@Override
	public void deleteProduct(long id) {
		String query = "delete from eproduct where id = :id";
		SqlParameterSource paramMap = new MapSqlParameterSource().addValue("id", id);
		namedParameterJdbcTemplate.update(query, paramMap);
	}

	@Override
	public List<Product> getAllProducts() {
		String query = "select * from eproduct";
		return namedParameterJdbcTemplate.query(query, new ProductRowMapper());
	}

	@Override
	public List<Object> getAllProductsWithJoin() {
		return null;
	}

	private class ProductRowMapper implements RowMapper<Product> {

		@Override
		public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
			Product product = new Product();
			product.setID(rs.getLong("id"));
			product.setName(rs.getNString("name"));
			product.setPrice(rs.getBigDecimal("price"));
			product.setDateAdded(rs.getDate("date_added"));
			product.setCategoryId(rs.getLong("category_id"));
			return product;
		}

	}

}
