package com.durgasoft.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.durgasoft.beans.Employee;

public class Test35 {

	public static void main(String[] args) {

		ApplicationContext context=new ClassPathXmlApplicationContext("/com/durgasoft/resources/applicationContext.xml");
		Employee emp=(Employee) context.getBean("employeeBean");
		System.out.println(emp);
		
	}

}
