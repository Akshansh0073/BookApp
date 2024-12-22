package com.virtualBook.payload;

import com.virtualBook.entities.Address;
import com.virtualBook.entities.Order;

public class UserDto {

	private String id;
	private String name;
	private String email;
	private String password;
	private AddressDto address;


	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDto(String id, String name, String email, String password, AddressDto address) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.address = address;
	}

	public AddressDto getAddress() {
		return address;
	}

	public void setAddress(AddressDto address) {
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
