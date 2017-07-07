package com.igorsantana.training.shopping.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.igorsantana.training.shopping.model.Category;
import com.igorsantana.training.shopping.repository.CategoriesRepository;

@Controller
@RequestMapping("/admin/categories")
public class AdminCategoriesController {

	@Autowired
	private CategoriesRepository repository;

	@RequestMapping(value = { "", "/" })
	public ModelAndView index(Pageable pageable) {
		ModelAndView mav = new ModelAndView("admin/categories/list");
		Page<Category> pages = repository.findAll(pageable);
		mav.addObject("categories", pages);
		return mav;
	}
}
