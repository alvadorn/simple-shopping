package com.igorsantana.training.shopping.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.igorsantana.training.shopping.repository.UserRepository;

@Controller
public class LoginController {

	@Autowired
	public UserRepository repository;
	
	@RequestMapping("/admin/login")
	public String login(@AuthenticationPrincipal User user) {
		if (user != null) {
			return "redirect:/admin";
		}
		return "login";
	}
	
	@RequestMapping("/admin/first_register")
	public String login(com.igorsantana.training.shopping.model.User user) {
		if (((List) repository.findAll()).size() == 0) {
			System.out.println(repository.findAll().size());
			return "register.html";
		}
		return "redirect:/admin/";
	}
}
