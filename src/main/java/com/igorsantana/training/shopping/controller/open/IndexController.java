package com.igorsantana.training.shopping.controller.open;

import java.time.ZonedDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.igorsantana.training.shopping.model.Product;
import com.igorsantana.training.shopping.model.Promotion;
import com.igorsantana.training.shopping.repository.ProductRepository;
import com.igorsantana.training.shopping.repository.PromotionRepository;

@Controller
public class IndexController {

	@Autowired
	private ProductRepository productsRepository;
	
	@Autowired
	private PromotionRepository promotionsRepository;
	
	@RequestMapping("/")
	public ModelAndView index(Pageable pageable) {
		List<Promotion> promotions = promotionsRepository.findFirst10ByEndDateAfter(ZonedDateTime.now());
		Page<Product> products = productsRepository.findAll(pageable);
		ModelAndView mav = new ModelAndView("index/index");
		mav.addObject("promotions", promotions);
		mav.addObject("products", products);
		return mav;
	}
	
}
