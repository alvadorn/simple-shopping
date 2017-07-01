package com.igorsantana.training.shopping.repository;

import java.time.ZonedDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.igorsantana.training.shopping.model.Promotion;

public interface PromotionRepository extends JpaRepository<Promotion, Long> {
	
	List<Promotion> findFirst10ByEndDateAfter(ZonedDateTime date);
}
