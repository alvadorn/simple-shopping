package com.igorsantana.training.shopping.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.igorsantana.training.shopping.model.Category;

public interface CategoriesRepository extends JpaRepository<Category, Long> {
	
	@Query("select c from Category c where c.removed = false or c.removed is null")
	List<Category> findAll();
	
	@Query("select c from Category c where c.removed = false or c.removed is null")
	Page<Category> findAll(Pageable pageable);

}
