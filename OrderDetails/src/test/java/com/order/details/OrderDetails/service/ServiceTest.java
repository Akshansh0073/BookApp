package com.order.details.OrderDetails.service;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.order.details.OrderDetails.entities.BookResponse;
import com.order.details.OrderDetails.payload.BookResponseDto;
import com.order.details.OrderDetails.repo.BookResponserepo;

@SpringBootTest
public class ServiceTest {

	@Autowired
	private BookResponserepo repo;
	
	@Autowired
	private ModelMapper mapper;
	
	@Test
	public void dtoTest() {
		
		BookResponseDto bookResponseDto = new BookResponseDto();
		bookResponseDto.setQuantity(5);
		BookResponse map = mapper.map(bookResponseDto, BookResponse.class);
		BookResponse save = repo.save(map);
		BookResponseDto map2 = mapper.map(save, BookResponseDto.class);
		System.out.println(map2.getQuantity());
		
		
		
	}
}
