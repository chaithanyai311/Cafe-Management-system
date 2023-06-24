package com.shopping.service;

import java.util.List;

import com.shopping.model.Category;

public interface CategoryService {
	
	public List<Category> viewAllCategorys();  //Read
	
	public void addCategory(Category category);  //create
	
	public void updateCategory(Category category);  //update
	
	public void deleteCategory(int id);

}
