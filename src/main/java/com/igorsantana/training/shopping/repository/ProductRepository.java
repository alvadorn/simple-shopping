package com.igorsantana.training.shopping.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.igorsantana.training.shopping.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	@Query("select p from Product p where p.id = ?1 and (p.removed = false OR p.removed is null)")
	Product findOne(Long id);
	Page<Product> findAllByRemovedIsNullOrRemovedFalse(Pageable pageable);
}
