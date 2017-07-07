package com.igorsantana.training.shopping.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.igorsantana.training.shopping.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
	Page<Product> findAllByRemovedIsNullOrRemovedFalse(Pageable pageable);
	Product findOneByRemoved(Boolean removed);

}
