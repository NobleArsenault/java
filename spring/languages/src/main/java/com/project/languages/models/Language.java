package com.project.languages.models;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Email;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Language{
	@Id
	@GeneratedValue
	private Long id;

	// Member variables and annotations go here.
	@Size(min=1, max=64, message="Name cannot be blank")
	private String name;

	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}

	@Size(min=1, max=255, message="creator cannot be blank")
	private String creator;

	public void setCreator(String creator){
		this.creator=creator;
	}
	public String getCreator(){
		return creator;
	}

	@NotNull
	private double version;

	public void setVersion(double version){
		this.version=version;
	}

	public double getVersion(){
		return version;
	}
	
	@DateTimeFormat(pattern="MM:dd:yyyy HH:mm:ss")
	private Date createdAt;
	
	@DateTimeFormat(pattern="MM:dd:yyyy HH:mm:ss")
	private Date updatedAt;

	@PrePersist
	public void onCreate(){this.createdAt = new Date();}
	@PreUpdate
	public void onUpdate(){this.updatedAt = new Date();}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
	
	// Setters and Getters go here
	
	public Language(){
		this.createdAt = new Date();
		this.updatedAt = new Date();
	}
	public Language(String name, String creator, double version){
		this.name = name;
		this.creator = creator;
		this.version = version;
		this.createdAt = new Date();
		this.updatedAt = new Date();
	}
}
