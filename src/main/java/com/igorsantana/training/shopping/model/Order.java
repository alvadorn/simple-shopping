package com.igorsantana.training.shopping.model;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "\"order\"")
public class Order extends AbstractModel {

	@Column
	private Boolean paid;

	@ManyToOne(optional = false)
	@JoinColumn(name = "order_status_id", nullable = false)
	private OrderStatus status;

	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "amount", column = @Column(name = "total_price_amount")),
			@AttributeOverride(name = "currency", column = @Column(name = "total_price_currency")) })
	private Money totalPrice;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "order")
	private List<CartItem> cartItems;

	public Boolean getPaid() {
		return paid;
	}

	public void setPaid(Boolean paid) {
		this.paid = paid;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Money getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Money totalPrice) {
		this.totalPrice = totalPrice;
	}

	public List<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

}
