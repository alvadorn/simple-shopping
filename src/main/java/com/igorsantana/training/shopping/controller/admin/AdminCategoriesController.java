package com.igorsantana.training.shopping.controller.admin;

import java.time.OffsetDateTime;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

	@RequestMapping("/{id}")
	public ModelAndView show(@PathVariable("id") Category category) {
		ModelAndView mav = new ModelAndView("admin/categories/show");
		mav.addObject("category", category);
		return mav;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ModelAndView delete(@PathVariable("id") Category category) {
		OffsetDateTime time = OffsetDateTime.now();
		category.setUpdatedAt(time);
		category.setRemovedAt(time);
		category.setRemoved(true);
		repository.save(category);
		return new ModelAndView("redirect:/admin/categories");
	}

	@RequestMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Category category) {
		ModelAndView mav = new ModelAndView("admin/categories/edit");
		mav.addObject("category", category);
		return mav;
	}

	@RequestMapping("/new")
	public ModelAndView _new(Category category) {
		ModelAndView mav = new ModelAndView("admin/categories/new");
		mav.addObject("category", category);
		return mav;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView create(@Valid Category category, BindingResult result, RedirectAttributes attrib) {
		if (result.hasErrors()) {
			return _new(category);
		}
		OffsetDateTime time = OffsetDateTime.now();
		category.setCreatedAt(time);
		category.setUpdatedAt(time);
		repository.save(category);
		attrib.addFlashAttribute("message", "Category has been created successfully.");
		return new ModelAndView("redirect:/admin/categories");
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ModelAndView update(@Valid Category category, BindingResult result) {
		if (result.hasErrors()) {
			return edit(category);
		}
		Category found = repository.findOne(category.getId());
		if (found == null) {
			return new ModelAndView("error/404");
		}
		partialUpdate(category, found);
		category.setUpdatedAt(OffsetDateTime.now());
		repository.save(found);
		return new ModelAndView("redirect:/admin/categories");
	}

	private void partialUpdate(Category newCategory, Category dbCategory) {
		dbCategory.setDescription(newCategory.getDescription());
		dbCategory.setName(newCategory.getName());
	}
}
