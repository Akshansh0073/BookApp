package com.order.details.OrderDetails.service.impl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.details.OrderDetails.ExternalClasses.Book;
import com.order.details.OrderDetails.ExternalServices.BookService;
import com.order.details.OrderDetails.entities.BookResponse;
import com.order.details.OrderDetails.payload.BookResponseDto;
import com.order.details.OrderDetails.repo.BookResponserepo;
import com.order.details.OrderDetails.service.BookResponseService;
import org.springframework.web.client.RestTemplate;

@Service
public class BookResponseServiceImpl implements BookResponseService {

	@Autowired
	private BookResponserepo repo;
	
	@Autowired
	private ModelMapper mapper;

	@Autowired
	private RestTemplate restTemplate;

	private final Logger logger = LoggerFactory.getLogger(BookResponseServiceImpl.class);
	
	@Autowired
	private BookService service;
	
	@Override
	public BookResponseDto addBooks(BookResponseDto responseDto, Long bookId) {
		// http://localhost:8080/books/book/2

//		Book book = restTemplate.getForObject("http://VIRTUALBOOKSTORE/books/book/" + bookId, Book.class);
		Book book = service.getBookById(bookId);
		logger.info("{}",book);
		BookResponse map = mapper.map(responseDto, BookResponse.class);
		map.setBook(book);
		BookResponse save = repo.save(map);

        return mapper.map(save, BookResponseDto.class);
	}

	@Override
	public BookResponseDto getBooks(String responseId) {
		
		BookResponse byId = repo.findById(responseId).orElseThrow();
		return mapper.map(byId, BookResponseDto.class);
	}

}
