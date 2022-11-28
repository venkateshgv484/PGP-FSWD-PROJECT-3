package com.simplilearn.sportyshoes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.simplilearn.sportyshoes.dao.ProductDao;
import com.simplilearn.sportyshoes.entity.Product;

@Service
@Transactional
public class ProductService {

	@Autowired
	private ProductDao productDao;

	@Transactional
	public Product getProductById(long id) {
		return productDao.getProductById(id);
	}

	@Transactional
	public void updateProduct(Product product) {
		if (product.getID() == Long.valueOf(0)) {
			productDao.createProduct(product);
			return;
		}
		productDao.updateProduct(product);
	}

	@Transactional
	public void deleteProduct(long id) {
		productDao.deleteProduct(id);
	}

	@Transactional
	public List<Product> getAllProducts() {
		return productDao.getAllProducts();
	}

	@Transactional
	public List<Object> getAllProductsWithJoin() {
		return productDao.getAllProductsWithJoin();
	}

}
