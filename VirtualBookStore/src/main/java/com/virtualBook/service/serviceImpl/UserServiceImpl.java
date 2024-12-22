package com.virtualBook.service.serviceImpl;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.virtualBook.entities.User;
import com.virtualBook.exception.ResourceNotFoundException;
import com.virtualBook.exception.UserResourceNotFoundException;
import com.virtualBook.payload.UserDto;
import com.virtualBook.repo.UserRepo;
import com.virtualBook.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	@Override
	public UserDto saveUser(UserDto userDto) {
		String userId = UUID.randomUUID().toString();
		User user = modelMapper.map(userDto, User.class);
		user.setId(userId);
		User save = userRepo.save(user);
		UserDto savedUser = modelMapper.map(save, UserDto.class);
		return savedUser;
	}

	@Override
	public UserDto updateUser(String user_id, UserDto userDto) {

		User oldUser = userRepo.findById(user_id)
				.orElseThrow(() -> new UserResourceNotFoundException("User", "id", user_id));

		User user = modelMapper.map(userDto, User.class);
		oldUser.setName(user.getName());
		oldUser.setEmail(user.getEmail());
		oldUser.setPassword(user.getPassword());
		oldUser.setAddress(user.getAddress());

		User newUser = userRepo.save(oldUser);

		return modelMapper.map(newUser, UserDto.class);
	}

	@Override
	public List<UserDto> getAllUser() {

		String cacheKey = "allUsers";

		@SuppressWarnings("unchecked")
		List<UserDto> cachedUsers = (List<UserDto>) redisTemplate.opsForValue().get(cacheKey);

		if (cachedUsers != null) {
			redisTemplate.expire(cacheKey, Duration.ofMinutes(10));
			System.out.println("Fetching data from Redis cache...");
			return cachedUsers; // Return data from Redis cache
		}

		// Fetch data from database if not in cache
		System.out.println("Fetching data from database...");
		List<User> all = userRepo.findAll();
		List<UserDto> collect = all.stream().map(user -> modelMapper.map(user, UserDto.class))
				.collect(Collectors.toList());
		redisTemplate.opsForValue().set(cacheKey, collect);

		return collect;
	}

	@Override
	public UserDto getUserById(String user_id) {

//		String cacheKey = "userById";
//
//		UserDto cachedUser = (UserDto) redisTemplate.opsForValue().get(cacheKey);
//
//		if (cachedUser != null) {
//			redisTemplate.expire(cacheKey, Duration.ofMinutes(10));
//			System.out.println("Fetching data from Redis cache...");
//			return cachedUser; // Return data from Redis cache
//		}
//
//		System.out.println("Fetching data from database...");
		User user = userRepo.findById(user_id)
				.orElseThrow(() -> new UserResourceNotFoundException("User", "id", user_id));

//		redisTemplate.opsForValue().set(cacheKey, modelMapper.map(user, UserDto.class));

		return modelMapper.map(user, UserDto.class);
	}

	@Override
	public String deleteUser(String user_id) {
		User user = userRepo.findById(user_id)
				.orElseThrow(() -> new UserResourceNotFoundException("User", "id", user_id));
		userRepo.delete(user);
		return "User with user_id: " + user_id + " deleted successfully";
	}

}
