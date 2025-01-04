package com.order.details.OrderDetails.ExternalClasses;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Book {

	private Long id;
	private String title;
	private String author;
	private double price;
	
	@JsonIgnore
	private Long stock;
	private CategoryDto categoryDto;
	
	
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Long getStock() {
		return stock;
	}

	public void setStock(Long stock) {
		this.stock = stock;
	}


	public CategoryDto getCategoryDto() {
		return categoryDto;
	}


	public void setCategoryDto(CategoryDto categoryDto) {
		this.categoryDto = categoryDto;
	}


	public Book(Long id, String title, String author, double price, Long stock, CategoryDto categoryDto) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.price = price;
		this.stock = stock;
		this.categoryDto = categoryDto;
	}


	

}

