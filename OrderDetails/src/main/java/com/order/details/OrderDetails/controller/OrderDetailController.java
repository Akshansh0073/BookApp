package com.order.details.OrderDetails.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.order.details.OrderDetails.ExternalServices.OrderService;
import com.order.details.OrderDetails.payload.OrderDetailDto;
import com.order.details.OrderDetails.service.OrderDetailService;

@RestController
@RequestMapping("/orderdetail")
public class OrderDetailController {

	@Autowired
	private OrderDetailService service;


	@PostMapping
	public ResponseEntity<OrderDetailDto> create
	(@RequestParam String orderId, @RequestBody List<String> bookResponseIds)
	{
		OrderDetailDto orderDetail = service.createOrderDetail(orderId,bookResponseIds);
		return new ResponseEntity<OrderDetailDto>(orderDetail, HttpStatus.CREATED);
	}

	@GetMapping("/{orderDetailId}")
	public ResponseEntity<OrderDetailDto> getOrderDetails
	(@PathVariable String orderDetailId)
	{
		OrderDetailDto orderDetail = service.getByOrderDetailId(orderDetailId);
		return new ResponseEntity<OrderDetailDto>(orderDetail, HttpStatus.OK);
	}


}

