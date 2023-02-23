package com.durgasoft.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.validation.MapBindingResult;
import org.springframework.validation.ObjectError;

import com.durgasoft.beans.User;
import com.durgasoft.validations.UserValidations;

public class Test30 {

	public static void main(String[] args) {

		ApplicationContext context=new ClassPathXmlApplicationContext("com/durgasoft/resources/applicationContext.xml");
	    User user=(User) context.getBean("userBean");
	    System.out.println(user);
	    UserValidations userValidations=(UserValidations) context.getBean("userValidations");
	    Map<String, String> map=new HashMap<>();
	    MapBindingResult results=new MapBindingResult(map, "com.durgasoft.beans.User");
	    userValidations.validate(user, results);
	    List<ObjectError> errorList=results.getAllErrors();
	    for(ObjectError e:errorList)
	    {
	    	System.out.println(e.getDefaultMessage());
	    }
	
	}

}
