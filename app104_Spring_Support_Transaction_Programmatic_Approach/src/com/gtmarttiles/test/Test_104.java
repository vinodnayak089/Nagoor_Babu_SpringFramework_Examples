package com.gtmarttiles.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gtmarttiles.dao.TilesDao;

public class Test_104 {

	public static void main(String[] args) {

		ApplicationContext context=new ClassPathXmlApplicationContext("/com/gtmarttiles/resources/applicationContext.xml");
		TilesDao repo=(TilesDao)context.getBean("tilesdao");
		repo.transfer("121", 5000, "122");
	}

}
