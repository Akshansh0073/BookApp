package com.virtualBook;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import com.virtualBook.entities.Order;
import com.virtualBook.repo.OrderRepo;

@SpringBootTest
public class RedisTest {

	@Autowired
	private RedisTemplate redisTemplate;
	
	@Autowired
	private OrderRepo orderRepo;
	
	@Test
	void test() {
		redisTemplate.opsForValue().set("email", "akshansh@gmail.com");
		redisTemplate.opsForValue().get("email");
	}
	
	@Test
	void OrderRepoTest() {
		List<Order> byUserId = orderRepo.findByUserId("b5b686c8-1cec-40e7-9b74-dae1d7c0a5ce");
		System.out.println(byUserId.get(0).getAmount());
	}
}
