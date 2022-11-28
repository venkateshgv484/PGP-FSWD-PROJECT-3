package com.simplilearn.sportyshoes.dao;

import java.util.List;

import com.simplilearn.sportyshoes.entity.Product;

public interface ProductDao {

	public Product getProductById(long id);

	public void updateProduct(Product product);

	public void deleteProduct(long id);

	public List<Product> getAllProducts();

	public List<Object> getAllProductsWithJoin();

	void createProduct(Product product);

}
