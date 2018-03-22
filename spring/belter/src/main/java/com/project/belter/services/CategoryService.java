package com.project.categories_products.services;

import java.util.ArrayList;
import java.util.List;

// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.project.categories_products.repositories.CategoryRepository;
import com.project.categories_products.models.Category;


@Service
public class CategoryService {
	@Autowired
	private CategoryRepository cR;


	public CategoryService(CategoryRepository cR){
		this.cR = cR;

	}
	
	public void create(Category cat){
		System.out.println("ajshdbaskdjaskdjbaksdjb");
		cR.save(cat);
	}

	public void update(Category cat){
		cR.save(cat);
	}

	public ArrayList<Category> all(){
		return (ArrayList<Category>) cR.findAll();
	}

	public Category find(Long id){
		return cR.findOne(id);
	}

	public void destroy(Category cat){
		cR.delete(cat);
	}
}
