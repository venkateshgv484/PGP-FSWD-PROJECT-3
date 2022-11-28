package com.simplilearn.sportyshoes.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.simplilearn.sportyshoes.dao.PurchaseDao;
import com.simplilearn.sportyshoes.entity.Purchase;

@Repository(value = "purchaseDao")
public class PurchaseDaoImpl implements PurchaseDao {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public Purchase getPurchaseById(long id) {
		String query = "select * from purchases where id = :id";
		SqlParameterSource paramMap = new MapSqlParameterSource().addValue("id", id);
		try {
			return namedParameterJdbcTemplate.queryForObject(query, paramMap, new PurchaseRowMapper());
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public List<Purchase> getAllItems() {
		List<Purchase> list;
		String query = "select * from purchases";
		SqlParameterSource paramMap = new MapSqlParameterSource();
		try {
			list = namedParameterJdbcTemplate.query(query, paramMap, new PurchaseRowMapper());
		} catch (EmptyResultDataAccessException e) {
			list = new ArrayList<>();
		}
		return list;
	}

	@Override
	public List<Purchase> getAllItemsByUserId(long userId) {
		List<Purchase> list;
		String query = "select * from purchases where user_id = :user_id";
		SqlParameterSource paramMap = new MapSqlParameterSource().addValue("user_id", userId);
		try {
			list = namedParameterJdbcTemplate.query(query, paramMap, new PurchaseRowMapper());

		} catch (EmptyResultDataAccessException e) {
			list = new ArrayList<>();
		}
		return list;
	}

	@Override
	public long createPurchase(Purchase purchase) {
		String query = "insert into purchases (user_id, date, gross_total) values (:user_id, :date, :gross_total)";
		SqlParameterSource paramMap = new MapSqlParameterSource().addValue("user_id", purchase.getUserId())
				.addValue("date", purchase.getDate()).addValue("gross_total", purchase.getTotal());
		KeyHolder keyHolder = new GeneratedKeyHolder();
		namedParameterJdbcTemplate.update(query, paramMap, keyHolder);
		return keyHolder.getKeyAs(Long.class);
	}

	@Override
	public long updatePurchase(Purchase purchase) {
		String query = "update purchases set user_id = :user_id, date = :date, gross_total = :gross_total where where id = :id";
		SqlParameterSource paramMap = new MapSqlParameterSource().addValue("user_id", purchase.getUserId())
				.addValue("date", purchase.getDate()).addValue("gross_total", purchase.getTotal())
				.addValue("id", purchase.getID());
		namedParameterJdbcTemplate.update(query, paramMap);
		return purchase.getID();
	}

	@Override
	public void deletePurchase(long id) {
		String query = "delete from purchases where where id = :id";
		SqlParameterSource paramMap = new MapSqlParameterSource();
		namedParameterJdbcTemplate.update(query, paramMap);
	}

	private class PurchaseRowMapper implements RowMapper<Purchase> {

		@Override
		public Purchase mapRow(ResultSet rs, int rowNum) throws SQLException {
			Purchase purchase = new Purchase();
			purchase.setID(rs.getLong("id"));
			purchase.setUserId(rs.getLong("user_id"));
			purchase.setDate(rs.getDate("date"));
			purchase.setTotal(rs.getBigDecimal("gross_total"));
			return purchase;
		}

	}

}
