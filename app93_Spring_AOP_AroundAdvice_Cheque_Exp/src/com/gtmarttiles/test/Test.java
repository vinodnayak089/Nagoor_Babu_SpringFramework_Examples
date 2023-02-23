package com.gtmarttiles.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gtmarttiles.dto.Account;
import com.gtmarttiles.dto.Cheque;
import com.gtmarttiles.service.TilesService;

public class Test {

	public static void main(String[] args){

		ApplicationContext context=new ClassPathXmlApplicationContext("/com/gtmarttiles/resources/applicationContext.xml");
        Account acc= (Account) context.getBean("accountBean");
        Cheque cheque= (Cheque) context.getBean("chequeBean");
		TilesService service= (TilesService) context.getBean("tilesProxy");
		service.debit(acc, cheque);
        
		
	}
}
