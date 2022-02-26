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
import com.myapp.spring.model.Registration;


@SpringBootTest
public class RegistrationRepositoryTest {
	
	@Autowired
	private RegistrationRepository repository;
	
	private static File DATA_JSON= Paths.get("src","test","resources","registration.json").toFile();
	
	
	@BeforeEach
	public void setUp() throws JsonParseException, JsonMappingException, IOException {
		
		Registration Registrationdetails[]=new ObjectMapper().readValue(DATA_JSON, Registration[].class);
	// save each product to database
	Arrays.stream(Registrationdetails).forEach(repository::save);	
		
		
	}
	
	@AfterEach
	public void cleanUp() {
		repository.deleteAll();
		
	}
	
	 @Test
	@DisplayName("Test regdeatils found for a non existing emilid")
	public void testRegistrationFoundFornonExistingemailId() {
		
		// given three products in the database
		
		// when we retrieve a product using non existing id
		Registration Registrationdetails=repository.findById("abcd@gmail.com").orElseGet(()-> new Registration());
		
		// Then perform Assert Conditions To validate
		Assertions.assertNull(Registrationdetails.getEmailId(), 
				"Product With emailId ");
		
		}
	
	
	@Test
	@DisplayName("Test product saved sucessfully")
	public void testRegistrationdetialsSavedSucessfully() {
		
		// given a mock product
		Registration Registrationdetails = new Registration("devikadevi2704@gmail","27-04-1999","G.Devika","female","devika1234");
		Registrationdetails.setEmailId("devikadevi2704@gmail.com");
		
		// when we retrieve a product using non existing id
		Registration savedRegistrationdetails=repository.save(Registrationdetails);
		
		// Then perform Assert Conditions To validate
		Assertions.assertNotNull(savedRegistrationdetails, 
				"New Product should be saved");
		
		Assertions.assertNotNull(savedRegistrationdetails.getEmailId(), 
				"New Product should have emailId");
		Assertions.assertEquals(Registrationdetails.getFullName(), 
				savedRegistrationdetails.getFullName());
		
		
		}
	
	/* @Test
	@DisplayName("Test product updated sucessfully")
	public void testProductUpdatedSucessfully() {
		
		// given a mock product
		Registration Registrationdetails = new Registration("devikadevi2704@gmail","27-04-1999","G.Devika","female","devika1234");
		Registrationdetails.setEmailId("devikadevi2704@gmail.com");
		
		// when we retrieve a product using non existing id
		Registration updatedRegistrationdetails=repository.save(Registrationdetails);
		
		
		Assertions.assertEquals(Registrationdetails.getEmailId(), 
				updatedRegistrationdetails.getEmailId());
		
		
		}*/
	

}
