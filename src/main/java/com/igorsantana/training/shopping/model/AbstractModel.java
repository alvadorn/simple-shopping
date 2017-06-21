package com.igorsantana.training.shopping.model;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;

	@Column
	protected Boolean removed;

	@Column(nullable = true, name = "removed_at")
	protected ZonedDateTime removedAt;

	@Column(nullable = false, name = "created_at")
	protected ZonedDateTime createdAt;

	@Column(nullable = false, name = "updated_at")
	protected ZonedDateTime updatedAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getRemoved() {
		return removed;
	}

	public void setRemoved(Boolean removed) {
		this.removed = removed;
	}

	public ZonedDateTime getRemovedAt() {
		return removedAt;
	}

	public void setRemovedAt(ZonedDateTime removedAt) {
		this.removedAt = removedAt;
	}

	public ZonedDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(ZonedDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public ZonedDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(ZonedDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

}
