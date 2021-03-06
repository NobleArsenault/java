package com.project.categories_products.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.categories_products.models.Category;

@Repository 												
public interface CategoryRepository extends CrudRepository<Category,Long>{
	// Query methods go here.
	
	// Example:
	// public YourModelHere findByName(Category name);
}
