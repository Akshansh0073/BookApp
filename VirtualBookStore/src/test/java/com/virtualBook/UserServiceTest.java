package com.virtualBook;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.virtualBook.service.UserService;

@SpringBootTest
public class UserServiceTest {

	@Autowired
	private UserService userService;
	
	@Test
	public void testFindUserByName() {
		assertNotNull(userService.getUserById("209ce48a-c0c2-4d6f-8c65-faf5a7c330d4"));
	}
	
	@Test
	public void testFindAllUserByName() {
		assertNotNull(userService.getAllUser());
	}
//	@BeforeAll
//	public static void init() {
//		System.out.println("single time logic");
//		
//	}
//	@AfterAll
//	public static void cleanup() {
//		System.out.println("After all test logic");
//		
//	}
//	@BeforeEach
//	public void beforeEachTestCase() {
//		System.out.println("Before each");
//	}
//	@AfterEach
//	public void afterEachTestCase() {
//		System.out.println("After each");
//	}
//	
//	@ParameterizedTest
//	@CsvSource({
//		"1,1,2"
//	})
//	public void test(int a, int b, int expect) {
//		System.out.println("test");
//		Assertions.assertEquals(expect, a+b, "test fails");
//	}
//	
//	@Disabled
//	@ParameterizedTest
//	@CsvSource({
//		"1,1,12"
//	})
//	public void test2(int a, int b, int expect) {
//		System.out.println("test1");
//		Assertions.assertEquals(expect, a+b, "test fails");
//	}
//	
}
