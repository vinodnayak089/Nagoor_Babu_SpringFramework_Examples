package com.gtmarttiles.advice;

import java.lang.reflect.Method;

import org.springframework.aop.ThrowsAdvice;

public class TilesThrowsAdvice implements ThrowsAdvice {
	
	public void afterThrowing(Method m, Object[] params, Object target, Exception e) {
		
		System.out.println("*****************************************");
		System.out.println("for method : "+m.getName()+" you have provided null design number please provide correct design number ");
		System.out.println("******************************************");

	}

}
