package com.virtualBook.service;

import java.util.List;

import com.virtualBook.entities.OrderStatus;
import com.virtualBook.payload.OrderDto;

public interface OrderService {

	
	OrderDto createOrder(String userId, OrderDto orderDto);
	
	OrderDto orderById(String order_id);
	
	List<OrderDto> orderByUserId(String userId);
	
	List<OrderDto> allOrder();
	
	OrderDto updateOrderStatus(String orderId,OrderStatus status);
	
	OrderDto updateOrder(String orderId, OrderDto orderDto);
}
