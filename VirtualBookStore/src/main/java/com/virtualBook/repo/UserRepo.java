package com.virtualBook.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virtualBook.entities.User;

public interface UserRepo extends JpaRepository<User, String>{

}
