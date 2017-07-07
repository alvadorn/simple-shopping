package com.igorsantana.training.shopping.util;

import org.springframework.data.domain.Example;
import com.igorsantana.training.shopping.model.AbstractModel;

public class DefaultExample {

	public static Example<AbstractModel> withNoRemoved(AbstractModel model) {
		model.setRemoved(false);
		return Example.of(model);
	}
}
