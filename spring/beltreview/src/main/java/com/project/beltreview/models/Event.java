package com.project.beltreview.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Email;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Event{
	@Id
	@GeneratedValue
	private long id;

	@Size(min=1,max=255, message="Name must be between 1-255 characters. ")
	private String name;

	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date date;

	@Size(min=1,max=255, message="city must be between 1-255 characters. ")
	private String city;

	@Size(min=2,max=3, message="state must be between 2-3 characters. ")
	private String state;


	
	@DateTimeFormat(pattern="MM:dd:yyyy HH:mm:ss")
	private Date createdAt;
	
	@DateTimeFormat(pattern="MM:dd:yyyy HH:mm:ss")
	private Date updatedAt;

	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
		name="users_events",
		joinColumns=@JoinColumn(name="event_id"),
		inverseJoinColumns=@JoinColumn(name="user_id")

	)
	private List<User> users;


	@OneToMany(mappedBy="event", fetch=FetchType.LAZY)
	private List<Message> messages;


	@PrePersist
	public void onCreate(){this.createdAt = new Date();}
	@PreUpdate
	public void onUpdate(){this.updatedAt = new Date();}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	public void setCity(String city){
		this.city=city;
	}
	public String getCity(){
		return this.city;
	}

	public void setState(String state){
		this.state=state;
	}
	public String getState(){
		return this.state;
	}

	public void setMessages(List<Message> messages){
		this.messages=messages;
	}
	public List<Message> getMessages(){
		return this.messages;
	}

	
	// Setters and Getters go here
	
	public Event(){
		this.createdAt = new Date();
		this.updatedAt = new Date();
	}
}
