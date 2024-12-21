package com.virtualBook.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtualBook.payload.ApiResponse;
import com.virtualBook.payload.BookDto;
import com.virtualBook.payload.CategoryDto;
import com.virtualBook.service.BookService;
import com.virtualBook.service.CategoryService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/categories")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/")
	public ResponseEntity<CategoryDto> saveCategory(@RequestBody CategoryDto categoryDto) {
		
		return new ResponseEntity<CategoryDto>
		(categoryService.createCategory(categoryDto),HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> getAllCategory() {
		List<CategoryDto> allCategory = categoryService.getAllCategory();
		return new ResponseEntity<List<CategoryDto>>(allCategory,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{cat_id}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable Long cat_id) {
		String deleteCategory = categoryService.deleteCategory(cat_id);
		ApiResponse reponse = new ApiResponse(deleteCategory, true);
		return new ResponseEntity<ApiResponse>(reponse,HttpStatus.OK);
	}
	
}
