package com.igorsantana.training.shopping.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;

@Entity
public class Product extends AbstractModel {

	@Column
	private String name;

	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "currency", column = @Column(name = "price_currency")),
			@AttributeOverride(name = "amount", column = @Column(name = "price_amount")) })
	private Money price;

	@Column(length = 1500)
	private String description;

	@Column(name = "photo_url", length = 500)
	private String photoUrl;

	@Column(name = "slug", length = 500, unique = true)
	private String slug;

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

}
