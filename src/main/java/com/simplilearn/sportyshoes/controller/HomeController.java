package com.simplilearn.sportyshoes.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.simplilearn.sportyshoes.entity.Category;
import com.simplilearn.sportyshoes.entity.Product;
import com.simplilearn.sportyshoes.service.CategoryService;
import com.simplilearn.sportyshoes.service.ProductService;

@Controller
public class HomeController {

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private ProductService productService;

	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public String home(ModelMap map, javax.servlet.http.HttpServletRequest request) {
		List<Product> list = productService.getAllProducts();

		// use MAP to map the category names to product rows
		HashMap<Long, String> mapCats = new HashMap<Long, String>();
		for (Product product : list) {
			Category category = categoryService.getCategoryById(product.getCategoryId());
			if (category != null)
				mapCats.put(product.getID(), category.getName());
		}

		map.addAttribute("list", list);
		map.addAttribute("mapCats", mapCats);
		map.addAttribute("pageTitle", "SPORTY SHOES - HOMEPAGE");
		return "index";
	}

}
