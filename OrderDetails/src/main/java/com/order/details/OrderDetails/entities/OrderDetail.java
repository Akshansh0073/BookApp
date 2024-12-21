package com.order.details.OrderDetails.entities;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.order.details.OrderDetails.ExternalClasses.Order;

@Document(collection = "order-details")
public class OrderDetail {

	@Id
	private String id;
	private int quantity;
	private double amount;
	
	@DBRef
	private List<BookResponse> books;
	private Order order;
	
	public OrderDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public OrderDetail(String id, int quantity, double amount, List<BookResponse> books, Order order) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.amount = amount;
		this.books = books;
		this.order = order;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public List<BookResponse> getBooks() {
		return books;
	}
	public void setBooks(List<BookResponse> books) {
		this.books = books;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order  ;
	}
	
	
}
