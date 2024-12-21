package com.virtualBook.payload;

import java.time.LocalDate;
import java.util.Date;

import com.virtualBook.entities.OrderStatus;
import com.virtualBook.entities.User;

public class OrderDto {

	private String id;
	private double amount;
	private OrderStatus status;
	private UserDto user;
	private LocalDate orderDate;
	
	public OrderDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderDto(String id, double amount, OrderStatus status, UserDto user, LocalDate orderDate) {
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
	public UserDto getUser() {
		return user;
	}
	public void setUser(UserDto user) {
		this.user = user;
	}
	public LocalDate getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
	
	
}
