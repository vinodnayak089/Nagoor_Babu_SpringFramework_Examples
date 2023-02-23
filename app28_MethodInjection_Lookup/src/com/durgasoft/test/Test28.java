package com.durgasoft.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.durgasoft.beans.CurrentAccount;
import com.durgasoft.beans.SavingAccount;
import com.durgasoft.factory.AccountFactory;

public class Test28 {

	public static void main(String[] args) {

		ApplicationContext context=new ClassPathXmlApplicationContext("com/durgasoft/resources/applicationContext.xml");
		
		AccountFactory savingAccountFactory=(AccountFactory) context.getBean("savingAccountFactory");
	    SavingAccount saving=  (SavingAccount) savingAccountFactory.getAccount();
		saving.create();
	    saving.delete();
	    saving.update();
	    saving.getAccountDetails();
	    
		AccountFactory currentAccountFactory=(AccountFactory) context.getBean("currentAccountFactory");
	    CurrentAccount currentAccount=(CurrentAccount) currentAccountFactory.getAccount();
	    currentAccount.create();
	    currentAccount.delete();
	    currentAccount.update();
	    currentAccount.getAccountDetails();
	}

}
