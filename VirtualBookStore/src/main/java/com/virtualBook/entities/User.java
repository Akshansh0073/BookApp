package com.virtualBook.entities;

import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class User {

	@Id
	@Column(name="id")
	private String user_id;
	
	@NotBlank
	private String name;
	
	@NotNull
	private String email;
	
	@NotNull
	private String password;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Order> order;

	@Embedded
	private Address address;
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String user_id, String name, String email, String password, List<Order> order, Address address) {
		this.user_id = user_id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.order = order;
		this.address = address;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Order> getOrder() {
		return order;
	}

	public void setOrder(List<Order> order) {
		this.order = order;
	}

	public String getId() {
		return user_id;
	}
	public void setId(String user_id) {
		this.user_id = user_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
