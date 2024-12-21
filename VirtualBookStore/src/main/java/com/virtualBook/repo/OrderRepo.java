package com.virtualBook.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.virtualBook.entities.Order;

public interface OrderRepo extends JpaRepository<Order, String> {
	
	@Query("Select o FROM Order o WHERE o.user.id = :userId")
    List<Order> findByUserId(String userId);

}
