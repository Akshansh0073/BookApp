package com.virtualBook.service;

import java.util.List;
import java.util.Map;

import com.virtualBook.payload.UserDto;

public interface UserService {

	// create
	UserDto saveUser(UserDto userDto);
	
	// update
	UserDto updateUser (String user_id, UserDto userDto);
	
	// get
	List<UserDto> getAllUser();
	
	// get by id
	UserDto getUserById (String user_id);
	
	// delete
	String deleteUser (String user_id);
}
