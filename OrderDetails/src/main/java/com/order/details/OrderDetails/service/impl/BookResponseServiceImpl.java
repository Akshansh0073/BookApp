package com.order.details.OrderDetails.service.impl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.details.OrderDetails.ExternalClasses.Book;
import com.order.details.OrderDetails.ExternalServices.BookService;
import com.order.details.OrderDetails.entities.BookResponse;
import com.order.details.OrderDetails.payload.BookResponseDto;
import com.order.details.OrderDetails.repo.BookResponserepo;
import com.order.details.OrderDetails.service.BookResponseService;

@Service
public class BookResponseServiceImpl implements BookResponseService {

	@Autowired
	private BookResponserepo repo;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private BookService externalBook;
	
	@Override
	public BookResponseDto addBooks(BookResponseDto responseDto, Long bookId) {
		// http://localhost:8080/books/book/2
		Book book = externalBook.getBookById(bookId);
		
		BookResponse map = mapper.map(responseDto, BookResponse.class);
		map.setBook(book);
		BookResponse save = repo.save(map);
		BookResponseDto map2 = mapper.map(save, BookResponseDto.class);
		
		return map2;
	}

	@Override
	public BookResponseDto getBooks(String responseId) {
		
		BookResponse byId = repo.findById(responseId).orElseThrow();
		return mapper.map(byId, BookResponseDto.class);
	}

}
