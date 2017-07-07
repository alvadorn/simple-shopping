package com.igorsantana.training.shopping.model;

import java.math.BigDecimal;

import javax.persistence.Embeddable;

@Embeddable
public class Money {

	private BigDecimal amount;
	private String currency;

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	@Override
	public String toString() {
		return currency + " " + amount;
	}

}
