package com.project.languages.services;

import java.util.ArrayList;
import java.util.List;

// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.languages.repositories.LanguageRepository;
import com.project.languages.models.Language;

@Service
public class LanguageService {
	private LanguageRepository lR;
	public LanguageService(LanguageRepository lR){
		this.lR = lR;
	}
	
	public void create(Language language){
		lR.save(language);
	}

	public Language find(Long id){
		return (Language) lR.findOne(id);
	}

	public void destroy(Long id){
		lR.delete(id);
	}

	public ArrayList<Language> all(){
		return (ArrayList<Language>) lR.findAll();
	}

	public void update(Language language){
		lR.save(language);
	}
}
