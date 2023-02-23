package com.durgasoft.validations;

import java.util.Properties;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.durgasoft.beans.User;

public class UserValidations implements Validator {
	
	private Resource resource;
	
	public void setResource(Resource resource) {
		this.resource = resource;
	}

	@Override
	public boolean supports(Class<?> cls) {
		return User.class.equals(cls);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		
		try {
			
			Properties prop=PropertiesLoaderUtils.loadProperties(resource);

			User user = (User) obj;

			if (user.getId() == 0) {
				errors.rejectValue("id", "error.uid", prop.getProperty("error.uid"));
			}

			if (user.getName() == "" || user.getName().equals(null)) {
				errors.rejectValue("name", "error.uname", prop.getProperty("error.uname"));
			}

			if (user.getAge() == 0) {
				errors.rejectValue("age", "error.uage", prop.getProperty("error.uage"));
			}
			if (user.getEmail() == "" || user.getEmail().equals(null)) {
				errors.rejectValue("email", "error.uemail", prop.getProperty("error.uemail"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
