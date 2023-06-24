package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.Product;
import com.app.service.ProductService;
@RestController
@RequestMapping("/products")
@CrossOrigin(origins="http://localhost:3000")


public class ProductCotroller {
	
	@Autowired
	private ProductService prodService;

	public ProductCotroller() {
		System.out.println("in home ctor"+getClass());
	}
	
	@GetMapping
	public List<Product> Showlist() {
		
		return prodService.getAllProduct();
	}
	
	@PostMapping
	public Product AddProduct(@RequestBody Product prod) {
		return prodService.AddProduct(prod);
	}
	
	@GetMapping("/")
	public String HomePage() {
		System.out.println("In home Page");
		return "In HomePage";
	}
	
}
