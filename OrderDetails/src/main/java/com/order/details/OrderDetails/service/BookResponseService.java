package com.order.details.OrderDetails.service;

import com.order.details.OrderDetails.payload.BookResponseDto;

public interface BookResponseService {

	
	BookResponseDto addBooks (BookResponseDto responseDto,Long bookId);
	
	BookResponseDto  getBooks (String responseId);
}
