package com.myapp.spring.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.spring.model.Products;
import com.myapp.spring.repository.ProductsRepository;

//This is a Class Which exposes Rest API's
@RestController
@RequestMapping("/api/v1/products")
public class ProductsApi {

//Dependency Injection
	@Autowired
	private ProductsRepository repository;

//http://localhost:8899/api/v1/products
	@GetMapping
	public ResponseEntity<List<Products>> findAll() {

		return new ResponseEntity<List<Products>>(repository.findAll(), HttpStatus.OK);
	}

	//http://localhost:8899/api/v1/products/findByPriceGreaterThan/45000

	@GetMapping("/findByPriceGreaterThan/{productPrice}")
	public ResponseEntity<List<Products>> findProductsByProductsPrice(@PathVariable("productPrice") Double productPrice) {

		return new ResponseEntity<List<Products>>(repository.findByProductPriceGreaterThanEqual(productPrice).get(),HttpStatus.OK);
	}

	// http://localhost:8899/api/v1/products/findByName?productName=samsung galaxy12
	@GetMapping("/findByName")
	public ResponseEntity<List<Products>> findProductsByName(@RequestParam("productName") Optional<String> productName) {
		return new ResponseEntity<List<Products>>(repository.findByProductNameLike(productName.orElse("")).get(),HttpStatus.OK);
	}

	// http://localhost:8899/api/v1/products/findByBrand?productBrand=samsung
	@GetMapping("/findByBrand")
	public ResponseEntity<List<Products>> findProductsByBrand(@RequestParam("productBrand") Optional<String> ProductBrand) {
		return new ResponseEntity<List<Products>>(repository.findByProductBrandLike(ProductBrand.orElse("")).get(),HttpStatus.OK);
	}

	// http://localhost:8899/api/v1/products/findByProductname=
	@GetMapping("/findByProductName")
	public ResponseEntity<List<Products>> findProductsByProductName(@RequestParam("productName") Optional<String> ProductName) {
		return new ResponseEntity<List<Products>>(repository.findByProductNameIgnoreCase(ProductName.orElse("")).get(),HttpStatus.OK);
	}
}
