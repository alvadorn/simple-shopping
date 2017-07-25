package com.igorsantana.training.shopping.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.igorsantana.training.shopping.repository.UserRepository;

@Component(value="userDetailsService")
public class UserDetailsImpl implements UserDetailsService {

	@Autowired
	private UserRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.igorsantana.training.shopping.model.User user = repository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("Invalid username or password");
		}
		return new User(username, user.getPassword(), getAuthority(user));
	}

	private List getAuthority(com.igorsantana.training.shopping.model.User user) {
		///List<Role> roles = user;//.// TODO Auto-generated method stub
		return null;
	}

}
