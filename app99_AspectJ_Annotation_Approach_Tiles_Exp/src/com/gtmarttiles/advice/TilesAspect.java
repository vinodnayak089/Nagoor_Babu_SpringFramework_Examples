package com.gtmarttiles.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component("tilesAspect")
@Aspect
public class TilesAspect {

	@Before("execution(* com.gtmarttiles.service.TilesService.*(..))")
	public void before(JoinPoint jp) {
		System.out.println("before method " + jp.getSignature().getName());
	}

	@After("execution(* com.gtmarttiles.service.TilesService.*(..))")
	public void after(JoinPoint jp) {
		System.out.println("after method " + jp.getSignature().getName());
	}

	@AfterReturning(pointcut="execution(* com.gtmarttiles.service.TilesService.*(..))", returning="results")
	public void afterReturing(JoinPoint jp, Object results) throws Throwable {
		System.out.println("afterReturn method " + jp.getSignature().getName() + " the return value is :" + results);
	}
	
	@Around("execution(* com.gtmarttiles.service.TilesService.*(..))")
	public void around(ProceedingJoinPoint pjp) {
		System.out.println("around before method " + pjp.getSignature().getName());
		try {
			pjp.proceed();
		} catch (Throwable e) {
               e.printStackTrace();
		}
		System.out.println("around after method " + pjp.getSignature().getName());
	}

	@AfterThrowing(pointcut="execution(* com.gtmarttiles.service.TilesService.*(..))", throwing="t")
	public void afterThrow(JoinPoint jp, Throwable t) {
		System.out.println("afterThrow method " + jp.getSignature().getName() + " the error msg id "+t.getMessage());
	}
}
