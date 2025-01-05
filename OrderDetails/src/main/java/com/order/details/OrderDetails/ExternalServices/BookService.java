package com.order.details.OrderDetails.ExternalServices;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.order.details.OrderDetails.ExternalClasses.Book;

//@FeignClient(name = "book-service", url = "http://localhost:8082")
//@FeignClient(name = "VirtualBookStore")  // should be same as application name
@FeignClient(name = "VirtualBookStore", path = "/books", contextId = "bookServiceClient")
public interface BookService {

	@GetMapping("/book/{id}")
	Book getBookById(@PathVariable("id") Long bookId);
}
