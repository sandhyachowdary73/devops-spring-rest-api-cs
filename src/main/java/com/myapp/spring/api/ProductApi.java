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

import com.myapp.spring.model.Products;
import com.myapp.spring.repository.ProductRepository;

// This is a Class Which exposes Rest API's
@RestController
@RequestMapping("/api/v1/Products")
public class ProductApi {

// Dependency Injection
	@Autowired
	private ProductRepository repository;

// http://localhost:8080/api/v1/products2
	@GetMapping
	public ResponseEntity<List<Products>> findAll() {

		return new ResponseEntity<List<Products>>(repository.findAll(), HttpStatus.OK);
	}



// http://localhost:8080/api/v1/products2
	@PostMapping
	public ResponseEntity<Products> saveNewProduct(@RequestBody Products product) {

		return new ResponseEntity<Products>(repository.save(product), HttpStatus.CREATED);
	}

	@PostMapping("/bulk")
	public ResponseEntity<List<Products>> bulkProductsInsert(@RequestBody List<Products> products) {

		return new ResponseEntity<List<Products>>(repository.saveAll(products), HttpStatus.CREATED);
	}


	

	
}