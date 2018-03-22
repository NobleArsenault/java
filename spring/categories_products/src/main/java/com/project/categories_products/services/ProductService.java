package com.project.categories_products.services;

import java.util.ArrayList;
import java.util.List;

// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.project.categories_products.repositories.ProductRepository;
import com.project.categories_products.models.Product;


@Service
public class ProductService {
	@Autowired
	private ProductRepository pR;


	public ProductService(ProductRepository pR){
		this.pR = pR;

	}
	
	public void create(Product product){
		pR.save(product);
	}

	public void update(Product product){
		pR.save(product);
	}

	public ArrayList<Product> all(){
		return (ArrayList<Product>) pR.findAll();
	}

	public Product find(Long id){
		return pR.findOne(id);
	}

	public void destroy(Product product){
		pR.delete(product);
	}
}
