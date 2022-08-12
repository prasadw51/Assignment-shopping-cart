package com.assignment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
	List<Product> findByPname(String pname);
	
	List<Product> findByPrice(long price);
	
	List<Product> findByType(String type);
	
	List<Product> findByPnameOrPriceOrType(String product,long price, String type);
}
