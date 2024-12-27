package com.virtualBook.service.serviceImpl;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.virtualBook.entities.Book;
import com.virtualBook.entities.Category;
import com.virtualBook.exception.ResourceNotFoundException;
import com.virtualBook.payload.BookDto;
import com.virtualBook.payload.CategoryDto;
import com.virtualBook.repo.BookRepo;
import com.virtualBook.repo.CategoryRepo;
import com.virtualBook.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepo bookRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	private Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);
	
	public BookDto saveBook(Long categoryId,BookDto bookDto) {
		
		Category cat = categoryRepo.findById(categoryId).
				orElseThrow(() -> new ResourceNotFoundException("Category","id",categoryId));
		
		Book map = modelMapper.map(bookDto, Book.class);
		map.setCategory(cat);
		Book savedBook = bookRepo.save(map);
		logger.info("{}",savedBook.getCategory());
		BookDto map2 = modelMapper.map(savedBook, BookDto.class);
		map2.setCategoryDto(modelMapper.map(cat, CategoryDto.class));
//		logger.info("{}",map2.getCategoryDto());
		return map2;
	}

	
	@Override
	public List<BookDto> getAllBook() {
		
		List<Book> all = bookRepo.findAll();
		
		logger.info("{}",all.get(0).getCategory().getName());
		
		List<BookDto> collect = all.stream().map(book -> 
		{
		 Category category = book.getCategory();
		 CategoryDto catDto = modelMapper.map(category, CategoryDto.class);
		 BookDto bookDto = modelMapper.map(book, BookDto.class);
		 bookDto.setCategoryDto(catDto);
		 return	bookDto;
		 })
		.collect(Collectors.toList());
		
		logger.info("{}",collect.get(0).getCategoryDto().getName());
		
		return collect;
	}


	@Override
	public List<BookDto> getAllBookOfSameCategory(Long categoryId) {
		
		Category cat = categoryRepo.findById(categoryId).
				orElseThrow(() -> new ResourceNotFoundException("Category","id",categoryId));
		
		if(bookRepo.findByCategory(cat).isEmpty()) {
		
			throw new ResourceNotFoundException("Book", "category id", categoryId);
		
		} else {
			List<Book> byCategory = bookRepo.findByCategory(cat);
			
			List<BookDto> collect = byCategory.stream().map(book -> 
			{
				BookDto bookDto = modelMapper.map(book, BookDto.class);
		        bookDto.setCategoryDto(modelMapper.map(book.getCategory(), CategoryDto.class));
		        return bookDto;
			 })
			.collect(Collectors.toList());
			
			return collect;
		}
	}
	
	
	public BookDto getBookById(Long book_id) {

		String cacheKey = "bookById" + book_id;

		BookDto cachedUser = (BookDto) redisTemplate.opsForValue().get(cacheKey);

		if (cachedUser != null) {
			redisTemplate.expire(cacheKey, Duration.ofMinutes(10));
			System.out.println("Fetching data from Redis cache...");
			return cachedUser; // Return data from Redis cache
		}

		System.out.println("Fetching data from database...");
		Book book = bookRepo.findById(book_id)
				.orElseThrow(() -> new ResourceNotFoundException("Book", "id", book_id));
		
		Category category = book.getCategory();
		CategoryDto categoryDto = modelMapper.map(category, CategoryDto.class);
		BookDto bookDto = modelMapper.map(book, BookDto.class);
		bookDto.setCategoryDto(categoryDto);
		
		redisTemplate.opsForValue().set(cacheKey, bookDto);

		return bookDto;
	
		}


}
