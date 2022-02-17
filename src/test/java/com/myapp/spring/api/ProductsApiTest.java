package com.myapp.spring.api;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.myapp.spring.model.Products;
import com.myapp.spring.repository.ProductsRepository;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
public class ProductsApiTest {

	@MockBean
	private ProductsRepository repository;

	@Autowired
	private MockMvc mockMvc;

	

	@Test
	@DisplayName("Test All Products /api/v1/products/")
	public void testGetAllProducts() throws Exception {

// Prepare Mock Product
		Products product1 = new Products("OnePlus9Pro", "Awesome", "Oneplus", 70000.00);
		product1.setProductId(35);

		Products product2 = new Products("OnePlus8Pro", "Good", "oneplus", 60000.00);
		product2.setProductId(36);

		List<Products> products = new ArrayList<>();
		products.add(product1);
		products.add(product2);

// Prepare Mock Service Method

		doReturn(products).when(repository).findAll();

// Perform GET Request

		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/products"))
// Validate Status should be 200 OK and JSON response received
				.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))

// Validate Response Body

				.andExpect(jsonPath("$[0].productId", is(35))).andExpect(jsonPath("$[0].productReview", is("Awesome")))
				.andExpect(jsonPath("$[0].productName", is("OnePlus9Pro")))
				.andExpect(jsonPath("$[0].productPrice", is(70000.00)))
				.andExpect(jsonPath("$[0].productBrand", is("Oneplus")))

				.andExpect(jsonPath("$[1].productId", is(36))).andExpect(jsonPath("$[1].productReview", is("Good")))
				.andExpect(jsonPath("$[1].productName", is("OnePlus8Pro")))
				.andExpect(jsonPath("$[1].productPrice", is(60000.00)))
				.andExpect(jsonPath("$[1].productBrand", is("oneplus")));

	}

	
	 @Test
	  
	  @DisplayName("Test All Products By Price /api/v1/products/{productPrice}")
	  public void testGetAllProductsByPrice() throws Exception {
	  
	  // Prepare Mock Product 
	  Products product1 = new Products("OnePlus9pro","Awesome", "oneplus", 70000.00); 
	  product1.setProductId(35);
	  
	  Products product2 = new Products("SamsungGalaxy12", "Awesome", "Samsung",20000.00); 
	  product2.setProductId(36);
	  
	  Products product3 = new Products("Iphone13", "Awesome", "Iphone", 700000.00);
	  product3.setProductId(37);
	  
	  List<Products> products = new ArrayList<>(); 
	  products.add(product1);
	  products.add(product2); 
	  products.add(product3);
	  
	  // Prepare Mock Service Method double productPrice = 70000.00;
	  Double productPrice = 70000.00;
	  
	  doReturn(Optional.of(products)).when(repository).findByProductPriceGreaterThanEqual(productPrice);
	  
	  // Perform GET Request
	  
	  mockMvc.perform( MockMvcRequestBuilders.get("/api/v1/products/findByPriceGreaterThan/{productPrice}",productPrice)) 
	  .andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
	  
	  // Validate Response Body
	  
	  .andExpect(jsonPath("$[0].productId", is(35))).andExpect(jsonPath("$[0].productReview", is("Awesome")))
	  .andExpect(jsonPath("$[0].productName", is("OnePlus9pro")))
	  .andExpect(jsonPath("$[0].productPrice", is(70000.00)))
	  .andExpect(jsonPath("$[0].productBrand", is("oneplus")));
	  
	  /*.andExpect(jsonPath("$[1].productId",
	  is(36))).andExpect(jsonPath("$[1].productReview", is("Awesome")))
	  .andExpect(jsonPath("$[1].productName", is("SamsungGalaxy12")))
	  .andExpect(jsonPath("$[1].productPrice", is(20000.00)))
	  .andExpect(jsonPath("$[1].productBrand", is("samsung")))
	  
	  .andExpect(jsonPath("$[2].productId",
	  is(37))).andExpect(jsonPath("$[2].productReview", is("Awesome")))
	  .andExpect(jsonPath("$[2].productName", is("Iphone13")))
	  .andExpect(jsonPath("$[2].productPrice", is(700000.00)))
	  .andExpect(jsonPath("$[2].productBrand", is("Iphone")));*/
	  
	  }
	 

	

	
	
	

	@Test
	@DisplayName("Test All Products By Name /api/v1/products/{productName}")
	public void testGetAllProductsByName() throws Exception {

// Prepare Mock Product
		Products product1 = new Products("Iphone13", "Awesome", "Iphone", 700000.00);
		product1.setProductId(35);

		Products product2 = new Products("SamsungGalaxy12", "Awesome", "Samsung", 20000.00);
		product2.setProductId(36);

		List<Products> products = new ArrayList<>();
		products.add(product1);
		products.add(product2);

// Prepare Mock Service Method
		String productName = "SamsungGalaxy12";

		doReturn(Optional.of(products)).when(repository).findByProductNameLike(productName);

// Perform GET Request

		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/products/findByName").queryParam("productName" , productName))
// Validate Status should be 200 OK and JSON response received
	
				.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))

// Validate Response Body

				.andExpect(jsonPath("$[1].productId", is(36))).andExpect(jsonPath("$[1].productReview", is("Awesome")))
				.andExpect(jsonPath("$[1].productName", is("SamsungGalaxy12")))
				.andExpect(jsonPath("$[1].productPrice", is(20000.00)))
				.andExpect(jsonPath("$[1].productBrand", is("Samsung")));

				
	}

	@Test
	@DisplayName("Test All Products By Brand /api/v1/products/{productBrand}")
	public void testGetAllProductsByBrand() throws Exception {

// Prepare Mock Product
		Products product1 = new Products("Iphone13", "Awesome", "Iphone", 700000.00);
		product1.setProductId(35);

		Products product2 = new Products("SamsungGalaxy12", "Awesome", "Samsung", 20000.00);
		product2.setProductId(36);

		List<Products> products = new ArrayList<>();
		products.add(product1);
		products.add(product2);

// Prepare Mock Service Method
		String productBrand = "samsung";

		doReturn(Optional.of(products)).when(repository).findByProductBrandLike(productBrand);

// Perform GET Request

		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/products/findByBrand").queryParam("productBrand",productBrand))

// Validate Status should be 200 OK and JSON response received
				.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))

// Validate Response Body

				.andExpect(jsonPath("$[1].productId", is(36))).andExpect(jsonPath("$[1].productReview", is("Awesome")))
				.andExpect(jsonPath("$[1].productName", is("SamsungGalaxy12")))
				.andExpect(jsonPath("$[1].productPrice", is(20000.00)))
				.andExpect(jsonPath("$[1].productBrand", is("Samsung")));

				

	}
}
