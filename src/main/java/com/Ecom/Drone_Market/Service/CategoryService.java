package com.Ecom.Drone_Market.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Ecom.Drone_Market.Model.Category;


public interface CategoryService {

	public Category saveCategory(Category category);
	
	public Boolean existCategory(String Name);
	
	public List<Category> getAllCategory();
	
	public Boolean deleteCategory(int id);
	
	public Category getcategoryById(int id);
	
	
	
	
}
