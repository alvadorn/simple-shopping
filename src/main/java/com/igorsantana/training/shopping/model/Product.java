package com.igorsantana.training.shopping.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Product extends AbstractModel {

	@NotBlank(message = "{name.notBlank}")
	@Column
	private String name;

	@Valid
	@Embedded
	@AttributeOverrides({
			@AttributeOverride(name = "currency", column = @Column(nullable = false, name = "price_currency")),
			@AttributeOverride(name = "amount", column = @Column(nullable = false, name = "price_amount")) })
	private Money price;

	@Size(min = 100, max = 1500, message="Description size must be between 100 and 1500")
	@Column(length = 1500)
	private String description;

	@Column(name = "photo_url", length = 500)
	private String photoUrl;

	@Column(name = "slug", length = 500, unique = true)
	private String slug;

	@NotNull(message = "Category must be chosen")
	@ManyToOne(optional = false)
	private Category category;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Money getPrice() {
		return price;
	}

	public void setPrice(Money price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
