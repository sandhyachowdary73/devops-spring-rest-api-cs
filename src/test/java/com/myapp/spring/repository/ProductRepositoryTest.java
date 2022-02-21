package com.myapp.spring.repository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myapp.spring.model.Product;

@SpringBootTest
public class ProductRepositoryTest {

	@Autowired
	private ProductRepository repository;

	private static File DATA_JSON = Paths.get("src", "test", "resources", "products.json").toFile();

	@BeforeEach
	public void setUp() throws JsonParseException, JsonMappingException, IOException {

		Product products[] = new ObjectMapper().readValue(DATA_JSON, Product[].class);

// save each product to database
		Arrays.stream(products).forEach(repository::save);

	}

	@AfterEach
	public void cleanUp() {
		repository.deleteAll();

	}

	@Test
	@DisplayName("Test product not found for a non existing id")
	public void testProductNotFoundForNonExistingId() {

// given three products in the database

// when we retrieve a product using non existing id
		Product product = repository.findById(100).orElseGet(() -> new Product());

// Then perform Assert Conditions To validate
		Assertions.assertNull(product.getProductId(), "Product With Id 100 should not exist");

	}


	@Test
	@DisplayName("Test product updated sucessfully")
	public void testProductUpdatedSucessfully() {

// given a mock product
		Product product = new Product("Cake","Delicious","Bans",200.00);
		product.setProductId(1);

// when we retrieve a product using non existing id
		Product updatedProduct = repository.save(product);

		Assertions.assertEquals(product.getProductPrice(), updatedProduct.getProductPrice());

	}

}