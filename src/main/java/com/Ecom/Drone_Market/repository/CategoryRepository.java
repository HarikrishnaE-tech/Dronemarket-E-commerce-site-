package com.Ecom.Drone_Market.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Ecom.Drone_Market.Model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
	
	public Boolean existsByName(String name);
		

	
	
	

}



