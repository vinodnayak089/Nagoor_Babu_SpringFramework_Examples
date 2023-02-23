package com.durgasoft.beans;

import java.util.Locale;

import org.springframework.context.MessageSource;

public class I18NBean {
	
	 private MessageSource messageSource;
	 
	 public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	 	 
	 public void displayMessage() {
		 Locale le=new Locale("en","US");
		 Locale lt=new Locale("it","IT");
		 Locale lf=new Locale("fr","FR");
				 
		 System.out.println("Message: "+messageSource.getMessage("welcome", new Object[] {"en","US"}, le));
		 System.out.println("Message: "+messageSource.getMessage("welcome", new Object[] {"it","IT"}, lt));
		 System.out.println("Message: "+messageSource.getMessage("welcome", new Object[] {"fr","FR"}, lf));
	 }

}
