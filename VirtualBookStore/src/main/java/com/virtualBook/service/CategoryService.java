package com.virtualBook.service;

import java.util.List;

import com.virtualBook.payload.CategoryDto;

public interface CategoryService {

	
	CategoryDto createCategory (CategoryDto categoryDto);
	
	List<CategoryDto> getAllCategory ();
	
	String deleteCategory (Long category_id);
	
}
