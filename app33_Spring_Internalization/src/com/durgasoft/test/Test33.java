package com.durgasoft.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.durgasoft.beans.I18NBean;

public class Test33 {
	
	public static void main(String[] args)
	{
    ApplicationContext context=new ClassPathXmlApplicationContext("/com/durgasoft/resources/applicationContext.xml");
	I18NBean i18nBean=(I18NBean)  context.getBean("i18NBean");
	i18nBean.displayMessage();
	}

}
