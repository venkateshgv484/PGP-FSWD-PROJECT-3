package com.simplilearn.sportyshoes.dao;

import java.util.List;

import com.simplilearn.sportyshoes.entity.Category;

public interface CategoryDao {

	public Category getCategoryById(long id);

	public void updateCategory(Category category);

	public void deleteCategory(long id);

	public List<Category> getAllCategories();

	void createCategory(Category category);

}
