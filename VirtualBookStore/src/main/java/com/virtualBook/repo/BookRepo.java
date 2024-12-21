package com.virtualBook.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virtualBook.entities.Book;
import com.virtualBook.entities.Category;

public interface BookRepo extends JpaRepository<Book, Long> {

	
	List<Book> findByCategory(Category category);
}
