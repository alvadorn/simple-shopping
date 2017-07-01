package com.igorsantana.training.shopping.controller.open;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.igorsantana.training.shopping.model.Order;

@Controller
@RequestMapping("/cart")
public class OrderController {

	@RequestMapping("/")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("");
		return mav;
	}

	@RequestMapping(value = "/checkout", method = RequestMethod.POST)
	public ModelAndView checkout(Order cart) {
		if (SecurityContextHolder.getContext().getAuthentication() != null
				&& SecurityContextHolder.getContext().getAuthentication().isAuthenticated()) {
			ModelAndView mav = new ModelAndView("");
			return mav;
		} else {
			// TODO return login page
			return null;
		}

	}

}
