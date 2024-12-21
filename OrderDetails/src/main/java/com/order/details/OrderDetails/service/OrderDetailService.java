package com.order.details.OrderDetails.service;

import java.util.List;

import com.order.details.OrderDetails.payload.OrderDetailDto;

public interface OrderDetailService {

	
	OrderDetailDto createOrderDetail (String oId, List<String> bookResponseIds);
	
	OrderDetailDto getByOrderDetailId(String id);
}
