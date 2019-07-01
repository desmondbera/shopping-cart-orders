package com.order.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Categories {
	
	@Id
	private int id;
	@Column
	private String name;
	
	//Constructors
	public Categories(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Categories() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//Getters and Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	//Methods
	@Override
	public String toString() {
		return "Categories [id=" + id + ", name=" + name + "]";
	}
	
	
	
}
