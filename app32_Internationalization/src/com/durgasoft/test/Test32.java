package com.durgasoft.test;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class Test32 {

	public static void main(String[] args) {

		Locale locale=new Locale("it","IT");
		NumberFormat nf=NumberFormat.getInstance(locale);
		System.out.println(nf.format(1234567.678345));
		
		DateFormat date=DateFormat.getDateInstance(1, locale);
		System.out.println(date.format(new Date()));
		
		ResourceBundle bundle=ResourceBundle.getBundle("abc",locale);
		System.out.println(bundle.getString("welcome"));	
	}
}
