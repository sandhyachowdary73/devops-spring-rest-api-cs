package com.myapp.spring.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.spring.model.Product;
import com.myapp.spring.repository.ProductRepository;


// This is a Class Which exposes Rest API's
@RestController
@RequestMapping("/api/v1/products")
public class ProductApi {
	
	// Dependency Injection
	@Autowired
	private ProductRepository repository;
	
	// http://localhost:8080/api/v1/products
	@GetMapping
	public ResponseEntity<List<Product>> findAll(){
		
	return new ResponseEntity<List<Product>>(repository.findAll(), HttpStatus.OK);
	}
	
	

	
	@PutMapping("/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable("id") Integer id,
			@RequestBody Product product) throws ResourceNotFoundException{
		Product existingProduct = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException
	    		   ("Product not found for this id :: " + id));
		
		BeanUtils.copyProperties(product, existingProduct);
		
	return new ResponseEntity<Product>(repository.save(existingProduct), 
			HttpStatus.CREATED);
	}

	
	

}