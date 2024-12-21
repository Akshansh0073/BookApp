package com.order.details.OrderDetails.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.order.details.OrderDetails.entities.OrderDetail;

public interface OrderDetailRepo extends MongoRepository<OrderDetail, String> {

}
