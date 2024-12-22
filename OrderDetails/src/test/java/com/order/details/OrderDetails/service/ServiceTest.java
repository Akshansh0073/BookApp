package com.order.details.OrderDetails.service;

import com.order.details.OrderDetails.ExternalClasses.Order;
import com.order.details.OrderDetails.ExternalServices.OrderService;
import com.order.details.OrderDetails.payload.OrderDetailDto;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.order.details.OrderDetails.entities.BookResponse;
import com.order.details.OrderDetails.payload.BookResponseDto;
import com.order.details.OrderDetails.repo.BookResponserepo;

import java.util.List;

@SpringBootTest
public class ServiceTest {

	@Autowired
	private BookResponserepo repo;
	
	@Autowired
	private ModelMapper mapper;

	@Autowired
	private OrderService service;

	@Autowired
	private OrderDetailService orderDetailService;
	
	@Test
	public void dtoTest() {
		
		BookResponseDto bookResponseDto = new BookResponseDto();
		bookResponseDto.setQuantity(5);
		BookResponse map = mapper.map(bookResponseDto, BookResponse.class);
		BookResponse save = repo.save(map);
		BookResponseDto map2 = mapper.map(save, BookResponseDto.class);
		System.out.println(map2.getQuantity());
	}

	@Test
	public void orderDetailTest() {

		Order orderById = service.getOrderById("56f13795-def4-439f-b498-4c63a46ac8f8");
		List<String> bookResponseIds= List.of("676791f89a0c8040c8b88b3c","676792319a0c8040c8b88b3d");
		List<BookResponse> allById = repo.findAllById(bookResponseIds);
//		System.out.println(allById.get(1).getId());
//		OrderDetailDto orderDetail = orderDetailService.createOrderDetail("56f13795-def4-439f-b498-4c63a46ac8f8", "6767923a9a0c8040c8b88b3e");
//		System.out.println(orderDetail.getOrder().getOrderDate());
	}
}
