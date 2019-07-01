package com.order.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class OrderDetails {
	
	@Id
	private int id;
	@Column
	private int orderId;
	@Column
	private int itemId;
	@Column
	private int quantity;
	@Column
	private double price;
	
	//Constructor
	public OrderDetails(int id, int orderId, int itemId, int quantity, double price) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.itemId = itemId;
		this.quantity = quantity;
		this.price = price;
	}

	public OrderDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	//Setters and getters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "OrderDetails [id=" + id + ", orderId=" + orderId + ", itemId=" + itemId + ", quantity=" + quantity
				+ ", price=" + price + "]";
	}
	
}
