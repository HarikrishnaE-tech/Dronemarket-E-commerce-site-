package com.Ecom.Drone_Market.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Ecom.Drone_Market.Model.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
