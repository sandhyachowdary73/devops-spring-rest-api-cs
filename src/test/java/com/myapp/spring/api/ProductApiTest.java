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
import com.myapp.spring.model.Product;
import com.myapp.spring.repository.ProductRepository;

@SpringBootTest

@AutoConfigureMockMvc(addFilters = false)
public class ProductApiTest {

	@MockBean
	private ProductRepository repository;

	@Autowired
	private MockMvc mockMvc;

	@Test
	@DisplayName("Test Update Existing Product")
	public void testUpdateExistingProduct() throws Exception {

// Prepare Mock Product

		Product mockproduct = new Product("Cake","Delicious","Bans",250.00);

		Product productToBeUpdated = new Product("Cake","Delicious","Bans",250.00);
		productToBeUpdated.setProductId(2);

		mockproduct.setProductId(2);
// Prepare Mock Service Method

		doReturn(Optional.of(mockproduct)).when(repository).findById(2);

		doReturn(mockproduct).when(repository).save(ArgumentMatchers.any());

// Perform GET Request

		mockMvc.perform(put("/api/v1/products/{id}", 2)
// Validate Status should be 200 OK and JSON response received

				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(new ObjectMapper().writeValueAsString(productToBeUpdated)))

// Validate Response Body
		.andExpect(status().isCreated())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(jsonPath("$.productId", is(2))).andExpect(jsonPath("$.productName", is("Cake")))
        .andExpect(jsonPath("$.productReview", is("Delicious"))).andExpect(jsonPath("$.productBrand", is("Bans")))
        .andExpect(jsonPath("$.productPrice", is(250.00)));

	}

}