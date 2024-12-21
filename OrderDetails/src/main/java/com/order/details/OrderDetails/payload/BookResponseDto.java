package com.order.details.OrderDetails.payload;

import com.order.details.OrderDetails.ExternalClasses.Book;

public class BookResponseDto {

	private String id;
	private Integer quantity;
	private Book book;
	
	public BookResponseDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BookResponseDto(String id, Integer quantity, Book book) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.book = book;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	
}
