package com.order.details.OrderDetails.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.details.OrderDetails.ExternalClasses.Order;
import com.order.details.OrderDetails.ExternalServices.BookService;
import com.order.details.OrderDetails.ExternalServices.OrderService;
import com.order.details.OrderDetails.entities.BookResponse;
import com.order.details.OrderDetails.entities.OrderDetail;
import com.order.details.OrderDetails.payload.BookResponseDto;
import com.order.details.OrderDetails.payload.OrderDetailDto;
import com.order.details.OrderDetails.repo.BookResponserepo;
import com.order.details.OrderDetails.repo.OrderDetailRepo;
import com.order.details.OrderDetails.service.OrderDetailService;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

	@Autowired
	private OrderDetailRepo repo;
	
	@Autowired
	private BookResponserepo bookRepo;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private OrderService service;
	
	@Override
	public OrderDetailDto createOrderDetail(String oId, List<String> bookResponseIds) {
		
		Order order = service.getOrderById(oId);
		
		List<BookResponse> allById = bookRepo.findAllById(bookResponseIds);
//		System.out.println(allById.get(0).getId());
		
		int totalQuantity = 0;
        double totalAmount = 0.0;

        // Calculate the total quantity and amount
        for (BookResponse bookResponse : allById) {
            totalQuantity += bookResponse.getQuantity();
            totalAmount += bookResponse.getQuantity() * bookResponse.getBook().getPrice();
        }
        
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setQuantity(totalQuantity);
        orderDetail.setAmount(totalAmount);
        orderDetail.setBooks(allById);
        orderDetail.setOrder(order);
        
        OrderDetail save = repo.save(orderDetail);

		
		return mapper.map(save, OrderDetailDto.class);
	}

	@Override
	public OrderDetailDto getByOrderDetailId(String orderDetailId) {
		OrderDetail orderDetail = repo.findById(orderDetailId).orElseThrow();
		return mapper.map(orderDetail, OrderDetailDto.class);
		
	}

}
