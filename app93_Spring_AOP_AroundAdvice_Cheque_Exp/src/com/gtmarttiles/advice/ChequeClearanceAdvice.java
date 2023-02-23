package com.gtmarttiles.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import com.gtmarttiles.dto.Account;
import com.gtmarttiles.dto.Cheque;

public class ChequeClearanceAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation mi) throws Throwable {
		Object[] params = mi.getArguments();
		Account acc = (Account) params[0];
		Cheque cheque = (Cheque) params[1];
		System.out.println("Hello " + acc.getName() + " is coming for clearance with cheque number :"
				+ cheque.getChequeNo() + "with amount of :" + cheque.getAmount());
		mi.proceed();
		System.out.println(
				"Hello " + acc.getName() + "The amount :" + cheque.getAmount() + " has been debited from Account No :"
						+ acc.getAccount() + "Now the updated balance is :" + acc.getBalance());
		return null;
	}

}
