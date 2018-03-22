package com.project.beltreview.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.beltreview.repositories.MessageRepository;
import com.project.beltreview.models.Message;


@Service
public class MessageService {
	private MessageRepository messageRepository;
		
	public MessageService(MessageRepository messageRepository){
		this.messageRepository=messageRepository;
	}
	
	public void create(Message message){
		messageRepository.save(message);
	}

	public ArrayList<Message> all(){
		return (ArrayList<Message>) messageRepository.findAll();
	}

	public Message findById(long id){
		return (Message)messageRepository.findOne(id);
	}

	public void update(Message message){
		create(message);

		// or messageRepository.save(message);
	}

	public void destroy(long id){
		messageRepository.delete(id);
	}

}
