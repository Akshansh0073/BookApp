package com.virtualBook.service.serviceImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtualBook.entities.Order;
import com.virtualBook.entities.OrderStatus;
import com.virtualBook.entities.User;
import com.virtualBook.exception.UserResourceNotFoundException;
import com.virtualBook.payload.OrderDto;
import com.virtualBook.repo.OrderRepo;
import com.virtualBook.repo.UserRepo;
import com.virtualBook.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepo orderRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserRepo userRepo;
	
	@Override
	public OrderDto createOrder(String userId,OrderDto orderDto) {
		
		String orderId = UUID.randomUUID().toString();
		
		User user = userRepo.findById(userId).
				orElseThrow(() -> new UserResourceNotFoundException("User","id",userId));
		
		Order order = modelMapper.map(orderDto, Order.class);
		order.setId(orderId);
		order.setUser(user);
		order.setStatus(OrderStatus.PENDING);
		order.setOrderDate(LocalDate.now());
		Order save = orderRepo.save(order);
		return modelMapper.map(save, OrderDto.class);
	}


	@Override
	public List<OrderDto> allOrder() {
		List<Order> all = orderRepo.findAll();
		List<OrderDto> collect = all.stream().
				map(order -> modelMapper.map(order, OrderDto.class)).collect(Collectors.toList());
		return collect;
	}
	
	@Override
	public OrderDto orderById(String order_id) {
		Order order = orderRepo.findById(order_id).
				orElseThrow(() -> new UserResourceNotFoundException("Order","order-id",order_id));
		return modelMapper.map(order, OrderDto.class);
	}

	@Override
	public List<OrderDto> orderByUserId(String userId) {
		List<Order> byUserId = orderRepo.findByUserId(userId);
		List<OrderDto> collect = byUserId.stream().
				map(order -> modelMapper.map(order, OrderDto.class)).collect(Collectors.toList());
		return collect;
	}

	@Override
	public OrderDto updateOrderStatus(String orderId, OrderStatus status) {
		Order order = orderRepo.findById(orderId).
		orElseThrow(() -> new UserResourceNotFoundException("Order", "Order-id", orderId));
		order.setStatus(status);
		Order save = orderRepo.save(order);
		
		return modelMapper.map(save, OrderDto.class);
	}


	@Override
	public OrderDto updateOrder(String orderId, OrderDto orderDto) {
		Order order = modelMapper.map(orderDto, Order.class);
		Order oldOrder = orderRepo.findById(orderId).
				orElseThrow(() -> new UserResourceNotFoundException("Order","order-id",orderId));
		oldOrder.setAmount(order.getAmount());
		oldOrder.setOrderDate(LocalDate.now());
		oldOrder.setStatus(OrderStatus.UPDATE);
		
		Order newOrder = orderRepo.save(oldOrder);
		return modelMapper.map(newOrder, OrderDto.class);
	}


}
