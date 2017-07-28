package com.igorsantana.training.shopping.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.igorsantana.training.shopping.model.Product;
import com.igorsantana.training.shopping.repository.ProductRepository;

@RestController
public class AdminRestController {

	@Autowired
	private ProductRepository repository;

	@RequestMapping("/admin/api/products/search")
	public ResponseEntity<List<Product>> search(Product product) {
		ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreNullValues().withStringMatcher(StringMatcher.CONTAINING);
		Example<Product> example = Example.of(product, matcher);
		List<Product> products = repository.findAll(example);
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}
}
