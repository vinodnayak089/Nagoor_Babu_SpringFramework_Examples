package com.durgasoft.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.durgasoft.beans.Course;

public class Test29 {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/durgasoft/resources/applicationContext.xml");
        Course course=(Course) context.getBean("courseBean"); 
        course.getCourseDeatils();
	}

}
