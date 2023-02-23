package com.gtmarttiles.test;

import java.io.File;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gtmarttiles.dao.CustomerDao;
import com.gtmarttiles.dto.Customer;

public class Test {

	public static void main(String[] args) {

		ApplicationContext context=new ClassPathXmlApplicationContext("/com/gtmarttiles/resources/applicationContext.xml");
		CustomerDao repo=(CustomerDao)context.getBean("customerdao");
		while(true)
		{
			System.out.println();
			System.out.println("**** Welcome to GT MART Customer ****");
			Scanner sc=new Scanner(System.in);
			System.out.println("Select the available options :");
			System.out.println("1. Add tiles");
			System.out.println("2. Search tiles");
			System.out.println("5. Exit");
            int option=sc.nextInt();
        	Customer customer=new Customer();
            switch(option)
            {
            case 1: 
            	System.out.println("Addition");
        		System.out.println("Enter Customer Id");
        		customer.setCno(sc.nextInt());
        		System.out.println("Enter Customer name");
        		customer.setName(sc.next());
        		customer.setCus_Img(new File("D:/GT_MART_Images/gt_mart_card.jpg"));
        		customer.setCus_Resume(new File("D:/GT_MART_Images/Resume_PathlavatVinodNayak.docx"));
        		repo.insertCustomer(customer);
        		break;
            case 2:
            	System.out.println("Read");
            	Customer cus=repo.readCustomer();
            	System.out.println(cus);
            
            	break;
            case 5:
            	System.out.println("####Thanks for using Tiles application######");
            	System.exit(0);
            default:
            	System.out.println("Please provide a value between 1 to 5");
            	
            }
		}
	}

}
