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

import com.simplilearn.sportyshoes.dao.PurchaseItemDao;
import com.simplilearn.sportyshoes.entity.PurchaseItem;

@Repository(value = "purchaseItemDao")
public class PurchaseItemDaoImpl implements PurchaseItemDao {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public PurchaseItem getItemById(long id) {
		String query = "select * from purchase_items where id = :id";
		SqlParameterSource paramMap = new MapSqlParameterSource().addValue("id", id);
		return namedParameterJdbcTemplate.queryForObject(query, paramMap, new PurchaseItemRowMapper());
	}

	@Override
	public List<PurchaseItem> getAllItemsByPurchaseId(long purchaseId) {
		String query = "select * from purchase_items where purchase_id = :purchase_id";
		SqlParameterSource paramMap = new MapSqlParameterSource().addValue("purchase_id", purchaseId);
		return namedParameterJdbcTemplate.query(query, paramMap, new PurchaseItemRowMapper());
	}

	@Override
	public void createItem(PurchaseItem item) {
		String query = "insert into purchase_items (purchase_id, product_id, user_id, rate, quantity, price) values(:purchase_id, :product_id, :user_id, :rate, :quantity, :price)";
		SqlParameterSource paramMap = new MapSqlParameterSource().addValue("purchase_id", item.getPurchaseId())
				.addValue("product_id", item.getProductId()).addValue("user_id", item.getUserId())
				.addValue("rate", item.getRate()).addValue("quantity", item.getQty())
				.addValue("price", item.getPrice());
		namedParameterJdbcTemplate.update(query, paramMap);
	}

	@Override
	public void updateItem(PurchaseItem item) {
		String query = "update purchase_items set purchase_id = :purchase_id, product_id = :product_id, user_id = :user_id, rate = :rate, quantity = :quantity, price = :price where where id = :id";
		SqlParameterSource paramMap = new MapSqlParameterSource().addValue("id", item.getID())
				.addValue("purchase_id", item.getPurchaseId()).addValue("product_id", item.getProductId())
				.addValue("user_id", item.getUserId()).addValue("rate", item.getRate())
				.addValue("quantity", item.getQty()).addValue("price", item.getPrice());
		namedParameterJdbcTemplate.update(query, paramMap);
	}

	@Override
	public void deleteItem(long id) {
		String query = "delete from purchase_items where where id = :id";
		SqlParameterSource paramMap = new MapSqlParameterSource().addValue("id", id);
		namedParameterJdbcTemplate.update(query, paramMap);
	}

	@Override
	public void deleteAllItemsForPurchaseId(long purchaseId) {
		String query = "delete from purchase_items where where purchase_id = :purchase_id";
		SqlParameterSource paramMap = new MapSqlParameterSource().addValue("purchase_id", purchaseId);
		namedParameterJdbcTemplate.update(query, paramMap);
	}

	private class PurchaseItemRowMapper implements RowMapper<PurchaseItem> {

		@Override
		public PurchaseItem mapRow(ResultSet rs, int rowNum) throws SQLException {
			PurchaseItem purchaseItem = new PurchaseItem();
			purchaseItem.setID(rs.getLong("id"));
			purchaseItem.setPurchaseId(rs.getLong("purchase_id"));
			purchaseItem.setProductId(rs.getLong("product_id"));
			purchaseItem.setUserId(rs.getLong("user_id"));
			purchaseItem.setRate(rs.getBigDecimal("rate"));
			purchaseItem.setQty(rs.getInt("quantity"));
			purchaseItem.setPrice(rs.getBigDecimal("price"));
			return purchaseItem;
		}

	}

}
