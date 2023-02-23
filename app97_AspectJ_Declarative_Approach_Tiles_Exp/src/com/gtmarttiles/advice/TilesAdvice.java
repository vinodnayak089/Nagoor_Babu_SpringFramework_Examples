package com.gtmarttiles.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class TilesAdvice {

	public void before(JoinPoint jp) {
		System.out.println("before method " + jp.getSignature().getName());
	}

	public void after(JoinPoint jp) {
		System.out.println("after method " + jp.getSignature().getName());
	}

	public void afterReturing(JoinPoint jp, Object results) throws Throwable {
		System.out.println("afterReturn method " + jp.getSignature().getName() + " the return value is :" + results);
	}
	
	public void around(ProceedingJoinPoint pjp) {
		System.out.println("around before method " + pjp.getSignature().getName());
		try {
			pjp.proceed();
		} catch (Throwable e) {
               e.printStackTrace();
		}
		System.out.println("around after method " + pjp.getSignature().getName());
	}

	public void afterThrow(JoinPoint jp, Throwable t) {
		System.out.println("afterThrow method " + jp.getSignature().getName() + " the error msg id "+t.getMessage());
	}
}
