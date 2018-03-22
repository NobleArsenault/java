package com.project.languages.controllers;

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

import com.project.languages.services.LanguageService;
import com.project.languages.models.Language;

@Controller
@RequestMapping("/languages")
public class LanguageController{
	private LanguageService lS;

	public LanguageController(LanguageService lS){
		this.lS = lS;
	}
	
	@RequestMapping("")
	public String languages(Model model){
		model.addAttribute("languages", lS.all());
		model.addAttribute("language", new Language());
	
		return "languages";
	}

	@PostMapping("")
	public String create(@Valid @ModelAttribute("language") Language language,BindingResult result){

		if( result.hasErrors() ){
			return "languages";
		}

		lS.create(language);
		return "redirect:/languages";
	}

	@RequestMapping("{id}")
	public String findLanguage( @PathVariable("id") Long id, Model model){
		model.addAttribute("language", lS.find(id) );
		return "showLanguage";
	}

	@PostMapping("{id}/delete")
	public String delete(@PathVariable("id") Long id){
		lS.destroy(id);
		return "redirect:/languages";
	}

	@RequestMapping("{id}/edit")
	public String editLanguage( @PathVariable("id") Long id, Model model){
		model.addAttribute("language", lS.find(id) );
		return "updateLanguage";
	}
	@PostMapping("{id}/edit")
	public String update(@Valid @ModelAttribute("language") Language language, @PathVariable("id") Long id, Model model, BindingResult result){

		if( result.hasErrors() ){
			return "languages/{id}/edit";
		}

		lS.update(language);
		return "redirect:/languages";
	}
}
