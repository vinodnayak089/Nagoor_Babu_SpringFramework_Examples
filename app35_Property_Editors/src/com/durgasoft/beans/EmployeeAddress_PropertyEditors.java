package com.durgasoft.beans;

import java.beans.PropertyEditorSupport;

public class EmployeeAddress_PropertyEditors extends PropertyEditorSupport {

	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {

		EmployeeAddress empaddr=new EmployeeAddress();
		String[] str=text.split("-");
		empaddr.setHno(str[0]);
		empaddr.setStreet(str[1]);
		empaddr.setArea(str[2]);
		empaddr.setState(str[3]);
		super.setValue(empaddr);
	}
}
