package com.order.details.OrderDetails.controller;


import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.order.details.OrderDetails.payload.BookResponseDto;
import com.order.details.OrderDetails.service.BookResponseService;

@RestController
@RequestMapping("/bookresponse")
public class BookResponseController {

	@Autowired
	private BookResponseService service;

	Logger logger = LoggerFactory.getLogger(BookResponseController.class);
	
	@PostMapping
	@CircuitBreaker(name="bookResponse_book_breaker", fallbackMethod = "bookResponseBookFallback")
	public ResponseEntity<BookResponseDto>  create
	(@RequestBody BookResponseDto bookResponse, @RequestParam Long bookId)
	{
		BookResponseDto books = service.addBooks(bookResponse, bookId);
		return new ResponseEntity<BookResponseDto>(books,HttpStatus.CREATED);
		
	}

	public ResponseEntity<BookResponseDto>  bookResponseBookFallback
			(@RequestBody BookResponseDto bookResponse, @RequestParam Long bookId,Exception ex)
	{
		logger.info("Fallback is executed because service is down", ex.getMessage());
		BookResponseDto book = BookResponseDto.builder().id("1000").quantity(0).book(null).build();
		return new ResponseEntity<BookResponseDto>(book,HttpStatus.REQUEST_TIMEOUT);

	}
	
	@GetMapping("/{id}")
	public ResponseEntity<BookResponseDto>  retrive (@PathVariable String id)
	{
		BookResponseDto books = service.getBooks(id);
		return new ResponseEntity<BookResponseDto>(books,HttpStatus.OK);
	}
	
	
}
