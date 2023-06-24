package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.entities.Product;
import com.app.repository.ProductRepo;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepo prodRepo;
	@Override
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		return prodRepo.findAll();
	}

	@Override
	public Product AddProduct(Product prod) {
		// TODO Auto-generated method stub
		return prodRepo.save(prod);
	}

}
