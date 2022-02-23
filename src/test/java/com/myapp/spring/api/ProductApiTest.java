package com.myapp.spring.api;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
	@DisplayName("Test Delete Existing Product")
	public void testDeleteExistingProduct() throws Exception {

		// Prepare Mock Product
		Product mockproduct = new Product("BathSoap", "Good","Dove", 80.00);

		Product productToBeDeleted = new Product("BathSoap", "Good","Dove", 80.00);
		productToBeDeleted.setProductId(50);

		mockproduct.setProductId(50);
		// Prepare Mock Service Method

		doReturn(Optional.of(mockproduct)).when(repository).findById(50);

		doReturn(mockproduct).when(repository).save(ArgumentMatchers.any());

		// Perform GET Request

		mockMvc.perform(put("/api/v1/products/{id}", 50)
				// Validate Status should be 200 OK and JSON response received

				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(new ObjectMapper().writeValueAsString(productToBeDeleted)))

				// Validate Response Body
				.andExpect(status().isCreated())
			//	.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(jsonPath("$.productId", is(50))).andExpect(jsonPath("$.productName", is("BathSoap")))
				.andExpect(jsonPath("$.productBrand", is("Dove"))).andExpect(jsonPath("$.productPrice", is(80.00)))
				.andExpect(jsonPath("$.productReview",is ("Good")));
	}

	

/*@Test
	@DisplayName("Test Delete Existing Product")
	public void testDeleteExistingProduct() throws Exception {

// Prepare Mock Product

		Product mockproduct = new Product("Chocolate","Awesome","Dairymilk",100.00);

		Product productToBeDeleted = new Product("Chocolate","Awesome","Dairymilk",100.00);
//		productToBeDeleted.setProductId(1);

		mockproduct.setProductId(1);
// Prepare Mock Service Method

//		doReturn(Optional.of(mockproduct)).when(repository).findById(1);

		
		
		
		
		
		
		
		
		when(repository.deleteById(1));

// Perfom GET Request

		mockMvc.perform(delete("/api/v1/products/{id}", 1)
// Validate Status should be 200 OK and JSON response received

				.contentType(MediaType.APPLICATION_JSON).content("")
		.andExpect(status().isNoContent())
       
        .andExpect(jsonPath("$.productId").value(1))
        .andExpect(jsonPath("$.productName", is("Chocolate")))
        .andExpect(jsonPath("$.productReview", is("Awesome"))).andExpect(jsonPath("$.productBrand", is("Dairymilk")))
        .andExpect(jsonPath("$.productPrice", is(100.00)));
	}*/

}