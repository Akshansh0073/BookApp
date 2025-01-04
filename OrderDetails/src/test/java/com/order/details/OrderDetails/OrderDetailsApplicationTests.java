package com.order.details.OrderDetails;

import com.order.details.OrderDetails.service.OrderDetailService;
import com.order.details.OrderDetails.service.impl.OrderDetailServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class OrderDetailsApplicationTests {

	@Autowired
	private OrderDetailService service;

	@Test
	void contextLoads() {
		service.createOrderDetail
				("91306d99-b40a-4e77-8d89-7435c0d7999f", List.of("6766790ba3e1e56863771b24"));
	}

}
