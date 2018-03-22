package com.project.beltreview.controllers;

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

import com.project.beltreview.models.Event;
import com.project.beltreview.services.EventService;

import com.project.beltreview.models.User;
import com.project.beltreview.services.UserService;

import com.project.beltreview.models.Message;
import com.project.beltreview.services.MessageService;

@Controller
@RequestMapping("/events")
public class EventController{

	private EventService eventService;

	public EventController(EventService eventService){
		this.eventService=eventService;

	}
	@RequestMapping("")
	public String events(@ModelAttribute("event") Event event){
		return "events";
	}

	@PostMapping("/new")
	public String create(@Valid @ModelAttribute("event") Event event, BindingResult res){
		if(res.hasErrors()){return "events";}

		eventService.create(event);
		return "redirect:/events";
	}

	@RequestMapping("/{id}")
	public String showEvent(@PathVariable("id") long id,Model model, @ModelAttribute("message") Message message){
		model.addAttribute("event", (Event)eventService.findById(id));

		return "showEvent";
	}
}
