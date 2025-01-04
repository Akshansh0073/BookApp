package com.virtualBook.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtualBook.payload.ApiResponse;
import com.virtualBook.payload.UserDto;
import com.virtualBook.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<UserDto> saveUser(@RequestBody UserDto userDto) {
		UserDto saveUser = userService.saveUser(userDto);
		return new ResponseEntity<>(saveUser,HttpStatus.CREATED);
	}
	
	
	@GetMapping
	public ResponseEntity<List<UserDto>> getAllUsers() {
		return new ResponseEntity<List<UserDto>>
		(userService.getAllUser(), HttpStatus.OK);
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getMethodName(@PathVariable String userId) {
		
		return new ResponseEntity<UserDto>
		(userService.getUserById(userId),HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<UserDto> updateUser(@PathVariable String id,
			@RequestBody UserDto userDto) {
		
		return new ResponseEntity<UserDto>
		(userService.updateUser(id, userDto),HttpStatus.OK);
	}
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable String userId) {
		String deleteUser = userService.deleteUser(userId);
		ApiResponse reponse = new ApiResponse(deleteUser, true);
		return new ResponseEntity<ApiResponse>(reponse,HttpStatus.OK);
	}

}
