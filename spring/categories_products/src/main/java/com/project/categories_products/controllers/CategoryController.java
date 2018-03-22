package com.project.categories_products.controllers;

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

import com.project.categories_products.services.CategoryService;
import com.project.categories_products.models.Category;


@Controller
@RequestMapping("/categories")
public class CategoryController{
	@Autowired
	private CategoryService cS;

	public CategoryController(CategoryService cS){
		this.cS = cS;
	}

	public CategoryController(){

	}
	
	@RequestMapping("/new")
	public String categories(Model model){
		model.addAttribute("category", new Category() );
		return "categories";
	}

	@PostMapping("/new")
	public String create( @Valid @ModelAttribute("category") Category cat, BindingResult result){
		if(result.hasErrors()){
			return "categories";
		}
		cS.create(cat);
		return "redirect:/categories/new";
	}
}

