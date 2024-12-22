package com.order.details.OrderDetails.ExternalServices;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.order.details.OrderDetails.ExternalClasses.Order;

@FeignClient(name = "order-service", url = "http://localhost:8082")
public interface OrderService {

	//http://localhost:8080/order/order/757871b5-1008-48b2-9ea3-2b6ead25f972
	@GetMapping("/order/order/{id}")
	Order getOrderById(@PathVariable("id") String oId);
	
}
