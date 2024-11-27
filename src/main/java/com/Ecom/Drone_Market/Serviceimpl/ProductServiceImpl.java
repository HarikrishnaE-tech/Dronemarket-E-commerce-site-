package com.Ecom.Drone_Market.Serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.Ecom.Drone_Market.Model.Product;
import com.Ecom.Drone_Market.Service.ProductService;
import com.Ecom.Drone_Market.repository.ProductRepository;
@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductRepository productRepository;

	@Override
	public Product saveProduct(Product product) {
		productRepository.save(product);
		return null;
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public Boolean deleteProduct(Integer id) {
		Product product = productRepository.findById(id).orElse(null);
		if(!ObjectUtils.isEmpty(product)) {
			productRepository.deleteById(id);
			return true;
		}
		else {
			
			return false;
		}
	}



}
