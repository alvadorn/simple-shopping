package com.igorsantana.training.shopping.controller.admin;

import java.text.SimpleDateFormat;
import java.time.OffsetDateTime;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.igorsantana.training.shopping.model.Product;
import com.igorsantana.training.shopping.repository.CategoriesRepository;
import com.igorsantana.training.shopping.repository.ProductRepository;

@Controller
@RequestMapping("/admin/products")
public class AdminProductController {

	@Autowired
	private ProductRepository repository;
	
	@Autowired
	private CategoriesRepository categoriesRepository;
	
	@InitBinder     
	public void initBinder(WebDataBinder binder){
	     SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm");
	     binder.registerCustomEditor(OffsetDateTime.class,new CustomDateEditor(dateFormat, false));   
	}

	@RequestMapping({ "/", "" })
	public ModelAndView index(Product product, @PageableDefault(size = 10) Pageable pageable) {
		ModelAndView mav = new ModelAndView("admin/products/list");
		Page<Product> pages = repository.findAllByRemovedIsNullOrRemovedFalse(pageable);
		mav.addObject("products", pages);
		mav.addObject("categories", categoriesRepository.findAll());
		return mav;
	}

	@RequestMapping("/{id}")
	public ModelAndView show(@PathVariable("id") Product product) {
		ModelAndView mav = new ModelAndView("admin/products/show");
		mav.addObject("product", product);
		return mav;
	}

	@RequestMapping("/new")
	public ModelAndView _new(Product product) {
		ModelAndView mav = new ModelAndView("admin/products/new");
		mav.addObject("product", product);
		mav.addObject("categories", categoriesRepository.findAll());
		return mav;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView create(@Valid Product product, BindingResult result, RedirectAttributes attrib) {
		if (result.hasErrors()) {
			return _new(product);
		}
		OffsetDateTime time = OffsetDateTime.now();
		product.setCreatedAt(time);
		product.setUpdatedAt(time);
		repository.save(product);
		attrib.addFlashAttribute("message", "Product created successfully.");
		return new ModelAndView("redirect:/admin/products");
	}

	@RequestMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Product product) {
		ModelAndView mav = new ModelAndView("admin/products/edit");
		mav.addObject("product", product);
		mav.addObject("categories", categoriesRepository.findAll());
		return mav;
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ModelAndView update(@Valid Product product, BindingResult result) {
		if (result.hasErrors()) {
			return edit(product);
		}
		Product found = repository.findOne(product.getId());
		if (found == null) {
			return new ModelAndView("error/404");
		}
		partialUpdate(product, found);
		product.setUpdatedAt(OffsetDateTime.now());
		repository.save(found);
		return new ModelAndView("redirect:/admin/products");
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ModelAndView delete(@PathVariable("id") Product product, RedirectAttributes attrib) {
		OffsetDateTime time = OffsetDateTime.now();
		product.setRemoved(true);
		product.setUpdatedAt(time);
		product.setRemovedAt(time);
		repository.save(product);

		attrib.addFlashAttribute("message", "Product removed successfully");
		return new ModelAndView("redirect:/admin/products");
	}

	private void partialUpdate(Product newProduct, Product dbProduct) {
		dbProduct.setCategory(newProduct.getCategory());
		dbProduct.setDescription(newProduct.getDescription());
		dbProduct.setName(newProduct.getName());
		dbProduct.setPhotoUrl(newProduct.getPhotoUrl());
		dbProduct.setPrice(newProduct.getPrice());
	}
	
}


