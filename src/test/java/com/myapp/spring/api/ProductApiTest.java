package com.myapp.spring.api;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myapp.spring.model.Products;
import com.myapp.spring.repository.ProductRepository;

@SpringBootTest

@AutoConfigureMockMvc(addFilters = false)
public class ProductApiTest {

	@MockBean
	private ProductRepository repository;

	@Autowired
	private MockMvc mockMvc;



	@Test
	@DisplayName("Test Add New Products")
	public void testAddNewProduct() throws Exception {

// Prepare Mock Product
		Products newproduct = new Products("Chocolate","Awesome","Dairymilk",100.00);

		Products mockproduct = new Products("Chocolate","Awesome","Dairymilk",100.00);
		mockproduct.setProductId(36);
// Prepare Mock Service Method

		doReturn(mockproduct).when(repository).save(ArgumentMatchers.any());

// Perform GET Request

		mockMvc.perform(post("/api/v1/Products")
// Validate Status should be 200 OK and JSON response received

				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(new ObjectMapper().writeValueAsString(newproduct)))

// Validate Response Body
		.andExpect(status().isCreated())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
		.andExpect(jsonPath("$.productId", is(36)))
		.andExpect(jsonPath("$.productName", is("Chocolate")))
		.andExpect(jsonPath("$.productReview", is("Awesome")))
		.andExpect(jsonPath("$.productBrand", is("Dairymilk")))
		.andExpect(jsonPath("$.productPrice", is(100.00)));
		
				
				

	}
	

}