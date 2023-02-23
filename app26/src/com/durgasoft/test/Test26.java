package com.durgasoft.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.durgasoft.beans.Student;

public class Test26 {

	public static void main(String[] args) {

		ApplicationContext context=new ClassPathXmlApplicationContext("com/durgasoft/resources/applicationContext.xml");
		Student stu=context.getBean(Student.class);
		stu.dispalyStudentDetails();
	}

}
