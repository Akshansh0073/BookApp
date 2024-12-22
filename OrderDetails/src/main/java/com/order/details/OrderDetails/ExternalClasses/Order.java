package com.order.details.OrderDetails.ExternalClasses;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;

public class Order {

	private String id;

	@JsonIgnore
	private double amount;
	private OrderStatus status;
	private User user;
	private LocalDate orderDate;
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(String id, double amount, OrderStatus status, User user, LocalDate orderDate) {
		super();
		this.id = id;
		this.amount = amount;
		this.status = status;
		this.user = user;
		this.orderDate = orderDate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public OrderStatus getStatus() {
		return status;
	}
	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public LocalDate getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
}
