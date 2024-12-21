package com.virtualBook.service;

import java.util.List;

import com.virtualBook.payload.BookDto;

public interface BookService {

	
	BookDto saveBook(Long categoryId,BookDto bookDto);
	
	List<BookDto> getAllBook();
	
	List<BookDto> getAllBookOfSameCategory(Long categoryId);
	
	BookDto getBookById(Long book_id);
}
