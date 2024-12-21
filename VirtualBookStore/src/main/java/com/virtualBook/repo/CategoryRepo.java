package com.virtualBook.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virtualBook.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Long>{

}
