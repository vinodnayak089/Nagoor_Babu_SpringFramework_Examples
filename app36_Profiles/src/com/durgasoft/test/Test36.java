package com.durgasoft.test;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.durgasoft.beans.AccountBean;

public class Test36 {

	public static void main(String[] args) {

		System.setProperty("spring.profiles.active","development");
		GenericXmlApplicationContext context=new GenericXmlApplicationContext();
		context.load("/com/durgasoft/resources/applicationContext-development.xml","/com/durgasoft/resources/applicationContext-production.xml");
		context.refresh();
		AccountBean bean=(AccountBean) context.getBean("accountBean");
		System.out.println(bean);
		
	}

}
