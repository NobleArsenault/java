package com.project.beltreview.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.beltreview.repositories.EventRepository;
import com.project.beltreview.models.Event;
import com.project.beltreview.models.User;

@Service
public class EventService {
	private EventRepository eventRepository;

	public EventService(EventRepository eventRepository){
		this.eventRepository=eventRepository;

	}

	public void create(Event event){
		eventRepository.save(event);
	}

	public ArrayList<Event> all(){
		return (ArrayList<Event>) eventRepository.findAll();
	}

	public Event findById(long id){
		return (Event)eventRepository.findOne(id);
	}

	public void update(Event event){
		create(event);

		// or eventRepository.save(event);
	}

	public void destroy(long id){
		eventRepository.delete(id);
	}

	public ArrayList<Event> findByState(String state){
		return (ArrayList<Event>)eventRepository.findByState(state);
	}
	
	// public ArrayList<Event> findByStateNotEquals(String state){
	// 	return (ArrayList<Event>)eventRepository.findByStateNotEquals(state);
	// }

}
