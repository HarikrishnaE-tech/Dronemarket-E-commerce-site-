package com.Ecom.Drone_Market.Serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.Ecom.Drone_Market.Model.Category;
import com.Ecom.Drone_Market.Service.CategoryService;
import com.Ecom.Drone_Market.repository.CategoryRepository;
@Service 
public class CategoryServiceimpl implements CategoryService{

	@Autowired
	CategoryRepository categoryRepository; 
	
	
	
	@Override
	public Category saveCategory(Category category) {
		return categoryRepository.save(category);
	}
	
	
	

	public List<Category> getAllCategory() {

		return categoryRepository.findAll();
	}




	@Override
	public Boolean existCategory(String name) {

		return categoryRepository.existsByName(name);
	}




	@Override
	public Boolean deleteCategory(int id) {
	Category category = categoryRepository.findById(id).orElse(null);
	if(!ObjectUtils.isEmpty(category)) {
		categoryRepository.delete(category);
		return true;
	}
		return false;
	}




	@Override
	public Category getcategoryById(int id) {
		Category category = categoryRepository.findById(id).orElse(null);
		return category;
	}

	
	
	
	
	
}
