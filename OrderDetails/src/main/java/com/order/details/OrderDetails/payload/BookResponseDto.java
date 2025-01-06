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

	public static class Builder {
		private String id;
		private Integer quantity;
		private Book book;

		public Builder id(String id) {
			this.id = id;
			return this;
		}

		public Builder quantity(Integer quantity) {
			this.quantity = quantity;
			return this;
		}

		public Builder book(Book book) {
			this.book = book;
			return this;
		}

		public BookResponseDto build() {
			return new BookResponseDto(id, quantity, book);
		}
	}

	// Static factory method to initiate the builder
	public static Builder builder() {
		return new Builder();
	}
}
