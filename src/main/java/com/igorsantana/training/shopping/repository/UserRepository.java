package com.igorsantana.training.shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.igorsantana.training.shopping.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByUsername(String username);

}
