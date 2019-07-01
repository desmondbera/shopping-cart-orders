package com.order.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Orders {
	
	@Id
	private int id;
	
	@Column(nullable = false)
	private String OrderNumber;
	
	@Column(nullable = false)
	private Date date;
	
	@Column(nullable = true)
	private String comments;
	
	@Column(nullable = false)
	private int status;

	//Constructors
	public Orders(int id, String orderNumber, Date date, String comments, int status) {
		super();
		this.id = id;
		OrderNumber = orderNumber;
		this.date = date;
		this.comments = comments;
		this.status = status;
	}

	public Orders() {
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

	public String getOrderNumber() {
		return OrderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		OrderNumber = orderNumber;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getcomments() {
		return comments;
	}

	public void setcomments(String comments) {
		this.comments = comments;
	}

	public double getstatus() {
		return status;
	}

	public void setstatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", OrderNumber=" + OrderNumber + ", date=" + date + ", comments=" + comments
				+ ", status=" + status + "]";
	}
	
}
