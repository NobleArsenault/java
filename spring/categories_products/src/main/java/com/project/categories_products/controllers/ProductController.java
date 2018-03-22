package com.project.categories_products.controllers;

import java.util.ArrayList;
import java.util.List;


import java.security.Principal;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.categories_products.services.ProductService;
import com.project.categories_products.services.CategoryService;

import com.project.categories_products.models.Product;
import com.project.categories_products.models.Category;



@Controller
@RequestMapping("/products")
public class ProductController{
	@Autowired
	private ProductService pS;
	private CategoryService cS;

	public ProductController(ProductService pS, CategoryService cS){
		this.pS=pS;
		this.cS=cS;
	}

	@RequestMapping("/new")
	public String products(@ModelAttribute("product") Product product){
		return "products";
	}

	@PostMapping("/new")
	public String create(@Valid @ModelAttribute("product") Product product, BindingResult res){
		if(res.hasErrors()){
			return "products";
		}

		pS.create(product);
		return "redirect:/products/new";
	}

	@RequestMapping("{id}")
	public String showProduct( @PathVariable("id") Long id, Model model){
		model.addAttribute("categories", cS.all());
		model.addAttribute("product", pS.find(id));
		return "showProduct";
	}

	@PostMapping("{product_id}/join")
	public String join( @RequestParam("category_id") Long category_id, @PathVariable("product_id") Long product_id){

		Product product = pS.find(product_id);
		List<Category> categories = product.getCategories();
		Category category = cS.find(category_id);
		categories.add(category);

		product.setCategories(categories);

		pS.update(product);
		return "redirect:/products/"+product_id;
	}

}
