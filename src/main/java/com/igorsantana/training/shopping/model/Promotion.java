package com.igorsantana.training.shopping.model;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "promotion")
public class Promotion extends AbstractModel {

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	private Product product;

	@Column(nullable = false, name = "end_date")
	private ZonedDateTime endDate;

	@Column(nullable = false, name = "percentage_off")
	private Double percentageOff;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public ZonedDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(ZonedDateTime endDate) {
		this.endDate = endDate;
	}

}
