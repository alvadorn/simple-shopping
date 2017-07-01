package com.igorsantana.training.shopping.controller.open;

import org.springframework.beans.factory.annotation.Autowired;
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

	@RequestMapping("/")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("product/index");
		return mav;
	}
	
	@RequestMapping("/{slug}")
	public ModelAndView show(@PathVariable("slug") Product product) {
		/*Product productFound = repository.findOne(Example.of(product));
		if (productFound) {
			
		}*/
		ModelAndView mav = new ModelAndView("");
		return mav;
	}
	
	
}
