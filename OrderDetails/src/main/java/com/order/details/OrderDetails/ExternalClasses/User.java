package com.order.details.OrderDetails.ExternalClasses;


import com.order.details.OrderDetails.ExternalClasses.Address;

public class User {

	private String id;
	private String name;
	private String email;
	private String password;
	private Address address;


	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String id, String name, String email, String password, Address address) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.address = address;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
