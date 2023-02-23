package com.durgasoft.Test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.durgasoft.beans.Account;

public class Test31 {

	public static void main(String[] args) {

		ApplicationContext context=new ClassPathXmlApplicationContext("com/durgasoft/resources/applicationContext.xml");
	    Account account=(Account) context.getBean("accountBean");
	    account.accountCreated();
	    account.accountDeleted();
	    account.accountDetails();
	    account.accountUpdated();
	
	}
}
