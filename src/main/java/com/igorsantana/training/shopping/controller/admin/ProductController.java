package com.igorsantana.training.shopping.controller.admin;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.igorsantana.training.shopping.model.Product;
import com.igorsantana.training.shopping.repository.ProductRepository;

@Controller
@RequestMapping("/admin/products")
public class ProductController {

	@Autowired
	private ProductRepository repository;

	@RequestMapping({ "/", "" })
	public ModelAndView index(@PageableDefault() Pageable pageable) {
		ModelAndView mav = new ModelAndView("admin/products");
		Page<Product> pages = repository.findAllByRemovedIsNullOrRemovedFalse(pageable);
		mav.addObject("products", pages);
		return mav;
	}

	@RequestMapping("/new")
	public ModelAndView _new(Product product) {
		ModelAndView mav = new ModelAndView("admin/products/new");
		mav.addObject("product", product);
		return mav;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView create(Product product, BindingResult result) {
		if (result.hasErrors()) {
			return _new(product);
		}
		return new ModelAndView("redirect:/admin/products");
	}

	@RequestMapping("/edit/{id}")
	public ModelAndView edit(@RequestParam("id") Product product) {
		Product found = repository.findOneByRemoved(false);
		if (found == null) {
			return new ModelAndView("error/404");
		}
		ModelAndView mav = new ModelAndView("admin/products/edit");
		mav.addObject("product", found);
		return mav;
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ModelAndView update(Product product, BindingResult result) {
		if (result.hasErrors()) {
			return edit(product);
		}
		product.setUpdatedAt(OffsetDateTime.now());
		repository.save(product);
		return new ModelAndView("redirect:/admin/products");
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public ModelAndView delete(Product product, RedirectAttributes attrib) {
		OffsetDateTime time = OffsetDateTime.now();
		product.setRemoved(true);
		product.setUpdatedAt(time);
		product.setRemovedAt(time);
		repository.save(product);

		attrib.addFlashAttribute("message", "Product removed successfully");
		return new ModelAndView("redirect:/admin/products");
	}

}
