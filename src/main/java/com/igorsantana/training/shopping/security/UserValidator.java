package com.igorsantana.training.shopping.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.igorsantana.training.shopping.model.User;

public class UserValidator implements Validator {
	
	@Autowired
	private UserService service;
	

	@Override
	public boolean supports(Class<?> class_) {
		return User.class.equals(class_);
	}

	@Override
	public void validate(Object obj, Errors err) {
		User user = (User) obj;
		ValidationUtils.rejectIfEmptyOrWhitespace(err, "username", "NotEmpty");
		
		if (user.getUsername().length() < 2) {
			err.rejectValue("username", "Too small name");
		}
		
		if (service.findByUsername(user.getUsername()) != null) {
			err.rejectValue("username", "Username is already registered.");
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(err, "password", "NotEmpty");
		if (user.getPassword().length() < 4) {
			err.rejectValue("password", "Password length");
		}
		
		if (!user.getPasswordConfirmation().equals(user.getPassword())) {
			err.rejectValue("passwordConfirmation", "Password Confirmation and password should be equal");
		}
		
	}

}
