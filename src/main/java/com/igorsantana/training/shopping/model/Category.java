package com.igorsantana.training.shopping.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "category")
public class Category extends AbstractModel {

	@NotBlank(message = "Name can't be blank")
	@Column(nullable = false)
	private String name;

	@Size(min = 50, max = 5500, message = "Description size must be between 50 and 500 characters")
	@Column(nullable = false, length = 500)
	private String description;

	@OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
	private List<Product> products;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

}
