package com.app.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.app.entities.Product;

@DataJpaTest 
@AutoConfigureTestDatabase(replace = Replace.NONE) 
@Rollback(false)
class ProdRepositoryTest {
	@Autowired
	private ProductRepo prodRepo;

	//String pname, int quantity, double price, String description
	@Test
	void testSaveAllprod() {
//		List<Product> prodlist=List.of("knife", 5, 250,"Sharp Cutter");
//				("Slicer", 3, 150,"good slicer"),
//				("Chirani", 10, 1250,"best chirani"));
//	
	

	}

}
