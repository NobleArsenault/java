package com.project.categories_products.models;

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

import com.project.categories_products.models.Category;

@Entity
public class Product{
	@Id
	@GeneratedValue
	private long id;

	@Size(min=1, max=255, message="Name cannot be blank")
	String name;

	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}

	@Size(min=1, max=1024, message="Product cannot be blank")
	String description;

	public void setDescription(String desc){
		description = desc;
	}
	public String getDescription(){
		return description;
	}

	@NotNull
	double price;

	public void setPrice(double price){
		this.price = price;
	}
	public double getPrice(){
		return price;
	}
	

	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
		name="categories_products",
		joinColumns=@JoinColumn(name="product_id"),
		inverseJoinColumns=@JoinColumn(name="category_id")
		)
	private List<Category> categories;

	public void setCategories(List<Category> categories){
		this.categories = categories;
	}
	public List<Category> getCategories(){
		return categories;
	}



	@DateTimeFormat(pattern="MM:dd:yyyy HH:mm:ss")
	private Date createdAt;
	
	@DateTimeFormat(pattern="MM:dd:yyyy HH:mm:ss")
	private Date updatedAt;

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
	
	
	public Product(){
		this.createdAt = new Date();
		this.updatedAt = new Date();
	}
}
