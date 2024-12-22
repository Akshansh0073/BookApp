package com.order.details.OrderDetails.payload;

import java.util.List;

import com.order.details.OrderDetails.ExternalClasses.Book;
import com.order.details.OrderDetails.ExternalClasses.Order;

public class OrderDetailDto {

	private String id;
	private int quantity;
	private double amount;
	private List<BookResponseDto> books;
	private Order order;
	
	public OrderDetailDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderDetailDto(String id, int quantity, double amount, List<BookResponseDto> books, Order order) {
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
	public List<BookResponseDto> getBooks() {
		return books;
	}
	public void setBooks(List<BookResponseDto> books) {
		this.books = books;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	
	
}
