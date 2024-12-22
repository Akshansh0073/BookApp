package com.virtualBook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtualBook.entities.Order;
import com.virtualBook.entities.OrderStatus;
import com.virtualBook.payload.OrderDto;
import com.virtualBook.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping("user/{userId}")
	public ResponseEntity<OrderDto> createOrder
	(@PathVariable String userId,@RequestBody OrderDto orderDto)
	{
		OrderDto created = orderService.createOrder(userId, orderDto);
		return new ResponseEntity<OrderDto>(created,HttpStatus.CREATED);
	}
	
	
	@GetMapping
	public ResponseEntity<List<OrderDto>> getAll() {
		List<OrderDto> created = orderService.allOrder();
		return new ResponseEntity<List<OrderDto>>(created,HttpStatus.OK);
	}
	
	@GetMapping("/order/{orderId}")
	public ResponseEntity<OrderDto> getOrderByOrderId(@PathVariable String orderId) {
		OrderDto created = orderService.orderById(orderId);
		return new ResponseEntity<OrderDto>(created,HttpStatus.OK);
	}
	
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<OrderDto>> getOrderByUserId(@PathVariable String userId) {
		List<OrderDto> orderByUserId = orderService.orderByUserId(userId);
		return new ResponseEntity<List<OrderDto>>(orderByUserId,HttpStatus.OK);
	}
	
	
	@PutMapping("/status/{orderId}")
	public ResponseEntity<OrderDto> updateStatus(@PathVariable String orderId, @RequestParam OrderStatus status) {
		
		OrderDto updateOrderStatus = orderService.updateOrderStatus(orderId, status);
		
		return new ResponseEntity<OrderDto>(updateOrderStatus,HttpStatus.OK);
	}
	
	@PutMapping("/order/{orderId}")
	public ResponseEntity<OrderDto> updateOrder(@PathVariable String orderId, @RequestBody OrderDto orderDto) {
		
		OrderDto updateOrderStatus = orderService.updateOrder(orderId, orderDto);
		
		return new ResponseEntity<OrderDto>(updateOrderStatus,HttpStatus.OK);
	}

}
