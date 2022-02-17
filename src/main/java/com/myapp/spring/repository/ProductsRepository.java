package com.myapp.spring.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myapp.spring.model.Products;

// This is a data repository class
@Repository
public interface ProductsRepository extends JpaRepository<Products, Integer> {

	// select * from products where UPPER(productName)=UPPER(?1)
	
	List<Products> findAll();
	
	Optional<List<Products>> findByProductPriceGreaterThanEqual(Double productPrice);
	
	Optional<List<Products>> findByProductNameLike(String productName);

	Optional<List<Products>> findByProductBrandLike(String productBrand);

	Optional<List<Products>> findByProductNameIgnoreCase(String productName);


}