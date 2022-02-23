package com.myapp.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myapp.spring.model.Product;

// This is a data repository class
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	
}
