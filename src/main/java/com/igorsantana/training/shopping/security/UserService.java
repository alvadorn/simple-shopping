package com.igorsantana.training.shopping.security;

import com.igorsantana.training.shopping.model.User;

public interface UserService {
	void save(User user);
	
	User findByUsername(String username);
}
