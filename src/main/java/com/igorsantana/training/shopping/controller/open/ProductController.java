package com.igorsantana.training.shopping.controller.open;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.igorsantana.training.shopping.model.Product;
import com.igorsantana.training.shopping.repository.ProductRepository;

@Controller
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductRepository repository;

	@RequestMapping(value = { "", "/" })
	public ModelAndView index(
			@PageableDefault(size = 9, sort = "updatedAt", direction = Direction.DESC) Pageable pageable) {
		ModelAndView mav = new ModelAndView("product/index");
		Page<Product> products = repository.findAll(pageable);
		mav.addObject("products", products);
		return mav;
	}

	@RequestMapping("/show/{slug}")
	public ModelAndView show(@PathVariable("slug") Product product) {
		/*
		 * Product productFound = repository.findOne(Example.of(product)); if
		 * (productFound) {
		 * 
		 * }
		 */
		ModelAndView mav = new ModelAndView("");
		return mav;
	}

}
