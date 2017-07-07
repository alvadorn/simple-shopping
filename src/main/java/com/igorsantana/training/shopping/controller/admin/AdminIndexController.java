package com.igorsantana.training.shopping.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class AdminIndexController {

	@RequestMapping(value = { "", "/" })
	public ModelAndView index() {
		return new ModelAndView("admin/index/index");
	}
}
