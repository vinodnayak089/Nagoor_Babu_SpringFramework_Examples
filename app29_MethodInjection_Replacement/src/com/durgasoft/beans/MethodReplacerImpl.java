package com.durgasoft.beans;

import java.lang.reflect.Method;

import org.springframework.beans.factory.support.MethodReplacer;

public class MethodReplacerImpl implements MethodReplacer {

	@Override
	public Object reimplement(Object arg0, Method arg1, Object[] arg2) throws Throwable {
		System.out.println("Course Details");
		System.out.println("Course name : Python");
		System.out.println("Course cost : 20000");
		return null;
	}
	

}
