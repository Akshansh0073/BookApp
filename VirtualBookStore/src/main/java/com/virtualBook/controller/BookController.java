package com.virtualBook.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtualBook.payload.BookDto;
import com.virtualBook.service.serviceImpl.BookServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/books/")
public class BookController {
	
	@Autowired
	private BookServiceImpl bookService;
	
	@PostMapping("category/{category_id}")
	public ResponseEntity<BookDto> createBook
	(@PathVariable Long category_id,@RequestBody BookDto bookDto) {
	
		BookDto saveBook = bookService.saveBook(category_id, bookDto);
		return new ResponseEntity<BookDto>(saveBook,HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<BookDto>> getAllBook() {
		List<BookDto> allBook = bookService.getAllBook();
		return new ResponseEntity<List<BookDto>>(allBook, HttpStatus.OK);
	}
	
	@GetMapping("/book/{bookid}")
	public ResponseEntity<BookDto> getBook(@PathVariable Long bookid) {
		BookDto book = bookService.getBookById(bookid);
		return new ResponseEntity<BookDto>(book, HttpStatus.OK);
	}
	
	@GetMapping("/category/{category_id}")
	public ResponseEntity<List<BookDto>> getAllBookByCategory
	(@PathVariable Long category_id) 
	{
		List<BookDto> allBook = bookService.getAllBookOfSameCategory(category_id);
		return new ResponseEntity<List<BookDto>>(allBook, HttpStatus.OK);
	}
	

}
