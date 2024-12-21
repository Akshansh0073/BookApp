package com.virtualBook.service.serviceImpl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtualBook.entities.Category;
import com.virtualBook.entities.User;
import com.virtualBook.exception.ResourceNotFoundException;
import com.virtualBook.payload.CategoryDto;
import com.virtualBook.repo.CategoryRepo;
import com.virtualBook.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		Category category = modelMapper.map(categoryDto, Category.class);
		Category save = categoryRepo.save(category);
		return modelMapper.map(save, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getAllCategory() {
		List<Category> categories = categoryRepo.findAll();
		List<CategoryDto> collect = categories.stream().map(cat-> modelMapper.map(cat, CategoryDto.class)).
		collect(Collectors.toList());
		return collect;
	}

	@Override
	public String deleteCategory(Long category_id) {
		Category cat = categoryRepo.findById(category_id).
				orElseThrow(() -> new ResourceNotFoundException("Category","id",category_id));
		categoryRepo.delete(cat);
		return "Category with category_id: " + category_id +" deleted successfully";
	}

}
