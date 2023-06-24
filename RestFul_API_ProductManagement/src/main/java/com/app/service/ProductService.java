package com.app.service;

import java.util.List;

import com.app.entities.Product;

public interface ProductService {
	
	List<Product>getAllProduct();
	
	Product AddProduct(Product prod);

}
