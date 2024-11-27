package com.Ecom.Drone_Market.Service;

import java.util.List;

import com.Ecom.Drone_Market.Model.Product;

public interface ProductService {

	public Product saveProduct(Product product);
	
	public List<Product> getAllProducts();
	
	public Boolean deleteProduct(Integer id);
	
	
}
