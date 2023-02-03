package com.durgasoft.test;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.durgasoft.config.AppConfig;
import com.durgasoft.controller.StudentControllerImpl;

public class Test {

	public static void main(String[] args) throws Exception {

		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		StudentControllerImpl studentController = (StudentControllerImpl) context.getBean("studentController");

		Scanner reader = new Scanner(System.in);

		while (true) {
			System.out.println("");
			System.out.println("Main Menu ");
			System.out.println("This is Appication for Student Crud Operation");
			System.out.println("Please enter your option");
			System.out.println(" 1 insert student");
			System.out.println(" 2 search student");
			System.out.println(" 3 update student");
			System.out.println(" 4 delete student");
			System.out.println(" 5 Exit form Application");
			int option = reader.nextInt();

			switch (option) {
			case 1:
				studentController.insert();
				break;
			case 2:
				studentController.search();
				break;

			case 3:
				studentController.update();
				break;

			case 4:
				studentController.delete();
				break;

			case 5:
				System.out.println("****Your Application is closed successfully****");
				System.exit(0);
			default:
				System.out.println("enter correct option");
				break;
			}
		}
	}

}
