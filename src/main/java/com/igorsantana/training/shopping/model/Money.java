package com.igorsantana.training.shopping.model;

import java.math.BigDecimal;

import javax.persistence.Embeddable;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Embeddable
public class Money {

	@NotNull(message="Amount can`t be blank")
	@Digits(fraction=2, integer = 6)
	private BigDecimal amount;
	
	@NotBlank(message="Currency can't be blank")
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
