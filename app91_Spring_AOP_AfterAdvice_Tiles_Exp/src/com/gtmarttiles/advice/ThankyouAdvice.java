package com.gtmarttiles.advice;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

import com.gtmarttiles.dto.Tiles;

public class ThankyouAdvice implements AfterReturningAdvice {

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] params, Object target) throws Throwable {

		Tiles tile = (Tiles) params[0];
		String customerName = (String)params[1];
		System.out.println("****************************************");
		System.out.println("Thank you Advice");
		System.out.println("Thanks "+ customerName +" for "+ method.getName() +" on design no: "+tile.getDesignNo()+" we will shortly call you");
		System.out.println("****************************************");
		
	}

}
