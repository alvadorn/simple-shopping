package com.igorsantana.training.shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.igorsantana.training.shopping.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
