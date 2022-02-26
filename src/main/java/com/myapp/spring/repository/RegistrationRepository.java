package com.myapp.spring.repository;

//import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myapp.spring.model.Registration;

// This is a data repository class
@Repository
public interface RegistrationRepository extends JpaRepository<Registration, String> {
	
	// select * from devopsproducts where UPPER(productName) = UPPER(?1)
//Optional<List<Product>> findByPriceGreaterThanEqual(Double price);
	
	Optional<List<Registration>> findByEmailId(String emailId);

	//Optional<List<Registration>> findByMailId(String emailId);
	
	//Optional<List<Product>> findByPriceIn(Collection<Double> prices);
	
	//Optional<List<Product>> findByProductNameIgnoreCase(String productName);
	
}