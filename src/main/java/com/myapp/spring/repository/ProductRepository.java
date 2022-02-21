package com.myapp.spring.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myapp.spring.model.Products;

// This is a data repository class
@Repository
public interface ProductRepository extends JpaRepository<Products, Integer> {

	
	

}
