package com.order.details.OrderDetails.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.order.details.OrderDetails.entities.BookResponse;

public interface BookResponserepo extends MongoRepository<BookResponse, String> {

}
