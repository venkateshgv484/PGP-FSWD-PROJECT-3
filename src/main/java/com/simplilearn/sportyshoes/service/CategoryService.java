package com.simplilearn.sportyshoes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.simplilearn.sportyshoes.dao.CategoryDao;
import com.simplilearn.sportyshoes.entity.Category;

@Service
@Transactional
public class CategoryService {

	@Autowired
	private CategoryDao categoryDao;

	public Category getCategoryById(long id) {
		return categoryDao.getCategoryById(id);
	}

	public void updateCategory(Category category) {
		if (category.getID() == Long.valueOf(0)) {
			categoryDao.createCategory(category);
			return;
		}

		categoryDao.updateCategory(category);
	}

	public void deleteCategory(long id) {
		categoryDao.deleteCategory(id);
	}

	public List<Category> getAllCategories() {
		return categoryDao.getAllCategories();
	}

	public String getCategoriesDropDown(long id) {
		StringBuilder sb = new StringBuilder("");
		List<Category> list = categoryDao.getAllCategories();
		for (Category cat : list) {
			if (cat.getID() == id)
				sb.append("<option value=" + String.valueOf(cat.getID()) + " selected>" + cat.getName() + "</option>");
			else
				sb.append("<option value=" + String.valueOf(cat.getID()) + ">" + cat.getName() + "</option>");

		}
		return sb.toString();
	}

}
